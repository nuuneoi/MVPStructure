package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter.IMainListAdapterPresenter;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter.MainListAdapterPresenterImpl;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.view.MainListAdapter;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.interactor.MainListFragmentInteractorImpl;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.presenter.IMainListFragmentPresenter;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.presenter.MainListFragmentPresenterImpl;
import com.inthecheesefactory.lab.mvpstructure.manager.Contextor;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListFragment extends Fragment implements IMainListFragmentView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    MainListAdapter mainListAdapter;

    IMainListFragmentPresenter presenter;

    IMainListAdapterPresenter mainListPresenter;

    public static MainListFragment newInstance() {
        MainListFragment fragment = new MainListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_list, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        ButterKnife.bind(this, rootView);

        presenter = new MainListFragmentPresenterImpl(this, new MainListFragmentInteractorImpl());

        mainListAdapter = new MainListAdapter();
        mainListPresenter = new MainListAdapterPresenterImpl(mainListAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mainListAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        presenter.loadDessertList();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
        mainListPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            presenter.onRestoreInstanceState(savedInstanceState);
            mainListPresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void showDessertList(boolean success, DessertItemCollectionDao dao) {
        if (success) {
            mainListPresenter.setData(dao);
            Toast.makeText(Contextor.getInstance().getContext(), "Loaded", Toast.LENGTH_SHORT).show();
        }
    }

}
