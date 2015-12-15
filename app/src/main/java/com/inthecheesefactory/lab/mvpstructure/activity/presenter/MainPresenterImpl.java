package com.inthecheesefactory.lab.mvpstructure.activity.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.activity.interactor.IMainInteractor;
import com.inthecheesefactory.lab.mvpstructure.activity.interactor.MainInteractorImpl;
import com.inthecheesefactory.lab.mvpstructure.activity.interactor.OnMainInteractorListener;
import com.inthecheesefactory.lab.mvpstructure.activity.view.IMainView;

import icepick.Icepick;
import icepick.State;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainPresenterImpl implements IMainPresenter, OnMainInteractorListener {

    private IMainView mainView;
    private IMainInteractor mainInteractor;

    @State
    String lastUsername = "";

    public MainPresenterImpl(IMainView mainView, IMainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void clear() {
        mainView.onClearText();
    }

    @Override
    public void login(String username, String password) {
        mainInteractor.login(username, password, this);
        lastUsername = username;
    }

    @Override
    public void onLoginResult(boolean success) {
        mainView.onLoginResult(success);
    }

    @Override
    public String getLastUsername() {
        return lastUsername;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

}
