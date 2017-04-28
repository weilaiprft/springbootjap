package com.fsb.docview.service.impl;

import com.fsb.docview.dao.ApiRequestDao;
import com.fsb.docview.model.ApiRequest;
import com.fsb.docview.service.ApiRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiRequestServiceImpl implements ApiRequestService {

    @Autowired
    private ApiRequestDao apiRequestDao;

    @Override
    public void create(ApiRequest apiRequest) {
        apiRequestDao.create(apiRequest);
    }
}
