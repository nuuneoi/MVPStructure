package com.inthecheesefactory.lab.mvpstructure.manager.http;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;

import retrofit.Call;
import retrofit.http.POST;

/**
 * Created by nuuneoi on 10/8/2015 AD.
 */
public interface APIService {

    @POST("list")
    Call<DessertItemCollectionDao> loadDesserts();

}
