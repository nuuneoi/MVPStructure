package com.inthecheesefactory.lab.mvpstructure.manager;

import android.content.Context;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();
        return instance;
    }

    private Context mContext;

    public void init(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

}
