package com.inthecheesefactory.lab.mvpstructure.activity.interactor;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface IMainInteractor {

    public void login(String username, String password, OnMainInteractorListener listener);

}
