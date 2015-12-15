package com.inthecheesefactory.lab.mvpstructure;

import android.app.Application;

import com.inthecheesefactory.lab.mvpstructure.manager.Contextor;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }
}
