package com.inthecheesefactory.lab.mvpstructure.activity.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.activity.main.interactor.MainInteractorImpl;
import com.inthecheesefactory.lab.mvpstructure.activity.main.presenter.MainPresenterImpl;
import com.inthecheesefactory.lab.mvpstructure.activity.main.presenter.IMainPresenter;
import com.inthecheesefactory.lab.mvpstructure.fragment.login.view.LoginFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {

    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        presenter = new MainPresenterImpl(this, new MainInteractorImpl());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, LoginFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.onRestoreInstanceState(savedInstanceState);
    }

}
