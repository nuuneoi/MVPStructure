package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter.IMainListAdapterPresenter;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.view.IMainListAdapterView;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.view.IMainListFragmentView;

import org.parceler.Parcels;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListAdapterPresenterImpl implements IMainListAdapterPresenter {

    IMainListAdapterView mainListAdapterView;
    DessertItemCollectionDao dao;

    public MainListAdapterPresenterImpl(IMainListAdapterView mainListAdapterView) {
        this.mainListAdapterView = mainListAdapterView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("mainListAdapterPresenterDao", Parcels.wrap(dao));
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        dao = Parcels.unwrap(savedInstanceState.getParcelable("mainListAdapterPresenterDao"));
        setData(dao);
    }

    @Override
    public void setData(DessertItemCollectionDao dao) {
        this.dao = dao;
        mainListAdapterView.setData(dao);
    }
}
