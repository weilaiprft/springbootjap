package com.fsb.docview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsb.docview.dao.DocViewDao;
import com.fsb.docview.model.DocView;
import com.fsb.docview.service.DocViewService;

@Service
@Transactional
public class DocViewServiceImpl implements DocViewService{

	@Autowired
    private DocViewDao docViewDao;
	
	@Override
	public void create(DocView docView) {
		// TODO Auto-generated method stub
		docViewDao.create(docView);
		
	}

}
