package com.inthecheesefactory.lab.mvpstructure.fragment.login.interactor;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class LoginFragmentInteractorImpl implements ILoginFragmentInteractor {

    @Override
    public void login(String username, String password, OnLoginFragmentInteractorListener listener) {
        if (username.equals("test") && password.equals("12345"))
            listener.onLoginResult(true);
        else
            listener.onLoginResult(false);
    }

}
