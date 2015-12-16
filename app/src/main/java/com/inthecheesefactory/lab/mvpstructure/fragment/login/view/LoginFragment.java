package com.inthecheesefactory.lab.mvpstructure.fragment.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.activity.mainlist.view.MainListActivity;
import com.inthecheesefactory.lab.mvpstructure.fragment.login.interactor.LoginFragmentInteractorImpl;
import com.inthecheesefactory.lab.mvpstructure.fragment.login.presenter.ILoginFragmentPresenter;
import com.inthecheesefactory.lab.mvpstructure.fragment.login.presenter.LoginFragmentPresenterImpl;
import com.inthecheesefactory.lab.mvpstructure.manager.Contextor;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class LoginFragment extends Fragment implements ILoginFragmentView {

    @Bind(R.id.editTextUsername)
    EditText editTextUsername;
    @Bind(R.id.editTextPassword)
    EditText editTextPassword;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnClear)
    Button btnClear;

    ILoginFragmentPresenter presenter;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        ButterKnife.bind(this, rootView);

        presenter = new LoginFragmentPresenterImpl(this, new LoginFragmentInteractorImpl());

        Observable<Boolean> usernameValid = RxTextView.afterTextChangeEvents(editTextUsername)
                .map(e -> e.view().getText().length() > 3 ? true : false);
        Observable<Boolean> passwordValid = RxTextView.afterTextChangeEvents(editTextPassword)
                .map(e -> e.view().getText().length() > 3 ? true : false);

        Observable<Boolean> loginEnabled = Observable.combineLatest(usernameValid, passwordValid, (a, b) -> a && b);
        loginEnabled.subscribe(b -> btnLogin.setEnabled(b));
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), presenter.getLastUsername(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            presenter.onRestoreInstanceState(savedInstanceState);
        }
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
        Toast.makeText(Contextor.getInstance().getContext(), "Result: " + success, Toast.LENGTH_SHORT)
                .show();

        if (success) {
            Intent intent = new Intent(getActivity(), MainListActivity.class);
            startActivity(intent);
        }
    }

}
