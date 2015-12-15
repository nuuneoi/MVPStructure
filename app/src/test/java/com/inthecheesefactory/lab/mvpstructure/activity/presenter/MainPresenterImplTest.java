package com.inthecheesefactory.lab.mvpstructure.activity.presenter;

import com.inthecheesefactory.lab.mvpstructure.activity.interactor.IMainInteractor;
import com.inthecheesefactory.lab.mvpstructure.activity.interactor.OnMainInteractorListener;
import com.inthecheesefactory.lab.mvpstructure.activity.view.IMainView;

import junit.framework.TestCase;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainPresenterImplTest extends TestCase {

    MainPresenterImpl mainPresenter;
    IMainView mainView;
    IMainInteractor mainInteractor;

    public void setUp() throws Exception {
        super.setUp();

        mainView = mock(IMainView.class);
        mainInteractor = mock(IMainInteractor.class);

        mainPresenter = new MainPresenterImpl(mainView, mainInteractor);
    }

    public void testClear() throws Exception {
        mainPresenter.clear();
        verify(mainView).onClearText();
    }

    public void testLogin() throws Exception {
        mainPresenter.login("nuuneoi", "12345");
        verify(mainInteractor).login(eq("nuuneoi"), eq("12345"), any(OnMainInteractorListener.class));
    }

    public void testOnLoginResult() throws Exception {

    }

}