package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor.IMainListFragmentInteractor;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.view.IMainListFragmentView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListFragmentPresenterImpl implements IMainListFragmentPresenter {

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
        mainListFragmentInteractor.getLoadDessertListStream()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<DessertItemCollectionDao>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DessertItemCollectionDao dessertItemCollectionDao) {
                        mainListFragmentView.showDessertList(true, dessertItemCollectionDao);
                    }
                });
    }

}
