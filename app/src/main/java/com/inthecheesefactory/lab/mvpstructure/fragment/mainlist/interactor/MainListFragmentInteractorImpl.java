package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.manager.http.HTTPManager;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListFragmentInteractorImpl implements IMainListFragmentInteractor {

    @Override
    public void loadDessertList(final OnMainListFragmentDessertListListener listener) {
        Call<DessertItemCollectionDao> call = HTTPManager.getInstance().getService().loadDesserts();
        call.enqueue(new Callback<DessertItemCollectionDao>() {
            @Override
            public void onResponse(Response<DessertItemCollectionDao> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    listener.onLoadFinished(true, response.body());
                } else {
                    listener.onLoadFinished(false, null);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLoadFinished(false, null);
            }
        });
    }

}
