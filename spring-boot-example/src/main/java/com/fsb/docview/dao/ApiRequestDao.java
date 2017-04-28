package com.fsb.docview.dao;

import com.fsb.docview.model.ApiRequest;

public interface ApiRequestDao {
    void create(ApiRequest apiRequest);

    void update(ApiRequest apiRequest);

    ApiRequest getApiRequestById(long id);

    void delete(long id);
}
