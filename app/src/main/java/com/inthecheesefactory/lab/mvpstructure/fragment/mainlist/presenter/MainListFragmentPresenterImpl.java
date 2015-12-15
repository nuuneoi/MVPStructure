package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor.IMainListFragmentInteractor;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor.OnMainListFragmentDessertListListener;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.view.IMainListFragmentView;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListFragmentPresenterImpl implements IMainListFragmentPresenter, OnMainListFragmentDessertListListener {

    IMainListFragmentView mainListFragmentView;
    IMainListFragmentInteractor mainListFragmentInteractor;

    public MainListFragmentPresenterImpl(IMainListFragmentView mainListFragmentView, IMainListFragmentInteractor mainListFragmentInteractor) {
        this.mainListFragmentView = mainListFragmentView;
        this.mainListFragmentInteractor = mainListFragmentInteractor;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

    }

    @Override
    public void loadDessertList() {
        mainListFragmentInteractor.loadDessertList(this);
    }

    @Override
    public void onLoadFinished(boolean success, DessertItemCollectionDao dao) {
        mainListFragmentView.onLoadFinished(success, dao);
    }

}
