package com.departmentclient.departmentclient.Service;

import com.departmentclient.departmentclient.Model.RequestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.departmentclient.departmentclient.Model.ResponseModel;



public interface ClientService {
    ResponseModel getData(int id);

    ResponseModel postData(RequestModel requestModel) throws JsonProcessingException;
}

