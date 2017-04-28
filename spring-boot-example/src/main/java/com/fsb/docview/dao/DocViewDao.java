package com.fsb.docview.dao;

import com.fsb.docview.model.DocView;

public interface DocViewDao {
	void create(DocView docView);

	void update(DocView docView);

	DocView getDocViewById(long id);

	void delete(long id);
}
