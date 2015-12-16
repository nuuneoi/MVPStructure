package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;

import rx.Observable;


/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface IMainListFragmentInteractor {

    Observable<DessertItemCollectionDao> getLoadDessertListStream();

}
