package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.manager.http.HTTPManager;

import rx.Observable;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListFragmentInteractorImpl implements IMainListFragmentInteractor {

    @Override
    public Observable<DessertItemCollectionDao> getLoadDessertListStream() {
        return HTTPManager.getInstance().getService().loadDessertsRx();
    }

}
