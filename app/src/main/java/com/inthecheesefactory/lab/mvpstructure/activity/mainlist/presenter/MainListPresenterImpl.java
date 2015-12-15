package com.inthecheesefactory.lab.mvpstructure.activity.mainlist.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.activity.mainlist.view.IMainListView;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListPresenterImpl implements IMainListPresenter {

    IMainListView mainListView;

    public MainListPresenterImpl(IMainListView mainListView) {
        this.mainListView = mainListView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

    }
}
