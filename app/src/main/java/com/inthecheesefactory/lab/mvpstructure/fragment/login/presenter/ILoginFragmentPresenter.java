package com.inthecheesefactory.lab.mvpstructure.fragment.login.presenter;

import com.inthecheesefactory.lab.mvpstructure.base.BasePresenter;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface ILoginFragmentPresenter extends BasePresenter {

    void clear();
    void login(String username, String password);

    String getLastUsername();

}
