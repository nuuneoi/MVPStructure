package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor;

import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public interface OnMainListFragmentDessertListListener {

    void onLoadFinished(boolean success, DessertItemCollectionDao dao);

}
