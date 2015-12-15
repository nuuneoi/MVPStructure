package com.inthecheesefactory.lab.mvpstructure.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface BasePresenter {

    public void onSaveInstanceState(@NonNull Bundle outState);
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState);

}
