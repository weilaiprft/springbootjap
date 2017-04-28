package com.fsb.docview.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fsb.docview.dao.DocViewDao;
import com.fsb.docview.model.DocView;

@Repository
public class DocViewDaoImpl implements DocViewDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(DocView docView) {
		// TODO Auto-generated method stub
		entityManager.persist(docView);
	}

	@Override
	public void update(DocView docView) {
		// TODO Auto-generated method stub
		entityManager.merge(docView);
	}

	@Override
	public DocView getDocViewById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(DocView.class, id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		DocView docView = getDocViewById(id);
        if (docView != null) {
            entityManager.remove(docView);
        }
	}

}
