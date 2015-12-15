package com.inthecheesefactory.lab.mvpstructure.activity.interactor;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainInteractorImpl implements IMainInteractor {

    @Override
    public void login(String username, String password, OnMainInteractorListener listener) {
        if (username.equals("test") && password.equals("12345"))
            listener.onLoginResult(true);
        else
            listener.onLoginResult(false);
    }

}
