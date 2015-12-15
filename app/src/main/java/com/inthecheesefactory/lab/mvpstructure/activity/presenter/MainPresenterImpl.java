package com.inthecheesefactory.lab.mvpstructure.activity.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.inthecheesefactory.lab.mvpstructure.activity.interactor.IMainInteractor;
import com.inthecheesefactory.lab.mvpstructure.activity.interactor.OnMainInteractorListener;
import com.inthecheesefactory.lab.mvpstructure.activity.model.UserModel;
import com.inthecheesefactory.lab.mvpstructure.activity.view.IMainView;

import org.parceler.Parcels;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainPresenterImpl implements IMainPresenter, OnMainInteractorListener {

    private IMainView mainView;
    private IMainInteractor mainInteractor;

    UserModel userModel;

    public MainPresenterImpl(IMainView mainView, IMainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;

        userModel = new UserModel();
    }

    @Override
    public void clear() {
        mainView.onClearText();
    }

    @Override
    public void login(String username, String password) {
        mainInteractor.login(username, password, this);
        userModel.setUsername(username);
    }

    @Override
    public void onLoginResult(boolean success) {
        mainView.onLoginResult(success);
    }

    @Override
    public String getLastUsername() {
        return userModel.getUsername();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable("userModel", Parcels.wrap(userModel));
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        userModel = Parcels.unwrap(savedInstanceState.getParcelable("userModel"));
    }

}
