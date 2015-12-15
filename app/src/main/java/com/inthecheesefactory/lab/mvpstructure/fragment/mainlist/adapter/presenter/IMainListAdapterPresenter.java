package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter;

import com.inthecheesefactory.lab.mvpstructure.base.BasePresenter;
import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface IMainListAdapterPresenter extends BasePresenter {

    void setData(DessertItemCollectionDao dao);

}
