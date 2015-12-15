package com.inthecheesefactory.lab.mvpstructure.activity.mainlist.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.activity.mainlist.presenter.IMainListPresenter;
import com.inthecheesefactory.lab.mvpstructure.activity.mainlist.presenter.MainListPresenterImpl;
import com.inthecheesefactory.lab.mvpstructure.fragment.login.view.LoginFragment;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.view.MainListFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainListActivity extends AppCompatActivity implements IMainListView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    IMainListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        presenter = new MainListPresenterImpl(this);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainListFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
