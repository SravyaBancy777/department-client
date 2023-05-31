package com.departmentclient.departmentclient.Controller;
import com.departmentclient.departmentclient.Model.RequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.departmentclient.departmentclient.Model.ResponseModel;
import com.departmentclient.departmentclient.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department-client")
public class Controller {

    @Autowired
    ClientService clientService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseModel> getData(@PathVariable int id) {
        ResponseModel responseModel = clientService.getData(id);
        if (responseModel == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<ResponseModel> createDepartment(@RequestBody RequestModel requestModel) throws JsonProcessingException, JsonProcessingException {
        ResponseModel responseModel = clientService.postData(requestModel);

        if(responseModel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

}
