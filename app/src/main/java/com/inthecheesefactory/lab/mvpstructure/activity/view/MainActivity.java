package com.inthecheesefactory.lab.mvpstructure.activity.view;

import android.renderscript.Short2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.activity.interactor.MainInteractorImpl;
import com.inthecheesefactory.lab.mvpstructure.activity.presenter.IMainPresenter;
import com.inthecheesefactory.lab.mvpstructure.activity.presenter.MainPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {

    @Bind(R.id.editTextUsername)
    EditText editTextUsername;
    @Bind(R.id.editTextPassword)
    EditText editTextPassword;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnClear)
    Button btnClear;

    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        presenter = new MainPresenterImpl(this, new MainInteractorImpl());
    }

    private void initInstances() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, presenter.getLastUsername(), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btnLogin)
    public void btnLoginClicked(View view) {
        presenter.login(editTextUsername.getText().toString(), editTextPassword.getText().toString());
    }

    @OnClick(R.id.btnClear)
    public void btnClearClicked(View view) {
        presenter.clear();
    }

    @Override
    public void onClearText() {
        editTextUsername.setText("");
        editTextPassword.setText("");
    }

    @Override
    public void onLoginResult(boolean success) {
        Toast.makeText(MainActivity.this, "Result: " + success, Toast.LENGTH_SHORT)
                .show();
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
