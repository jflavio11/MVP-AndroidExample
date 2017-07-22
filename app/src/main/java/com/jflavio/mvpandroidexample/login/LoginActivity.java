/*
 * Created by JoseFlavio on 7/22/17 1:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 12:59 AM
 */

package com.jflavio.mvpandroidexample.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jflavio.mvpandroidexample.R;
import com.jflavio.mvpandroidexample.sendemail.SendEmailActivity;
import com.jflavio.mvpandroidexample.utils.ErrorConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.loginActivity_et_email)
    EditText loginActivityEtEmail;
    @BindView(R.id.loginActivity_et_password)
    EditText loginActivityEtPassword;
    @BindView(R.id.loginActivity_btn_login)
    Button loginActivityBtnLogin;
    @BindView(R.id.loginActivity_pb)
    ProgressBar loginActivityPb;

    private LoginContract.UserActionListener userActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        if(userActionListener == null) userActionListener = new LoginPresenter(this);
        loginActivityBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userActionListener.login(loginActivityEtEmail.getText().toString(), loginActivityEtPassword.getText().toString());
            }
        });
    }

    @Override
    public void setLoader(boolean visible) {
        loginActivityPb.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(int errorType) {
        String text = getString(R.string.login_error_unknown);
        switch (errorType){
            case ErrorConstants.ERROR_INVALID_EMAIL:
                text = getString(R.string.login_error_invalidEmail);
                break;
            case ErrorConstants.ERROR_INVALID_PASSWORD:
                text = getString(R.string.login_error_invalidPassword);
                break;
            case ErrorConstants.ERROR_INVALID_LOGIN:
                text = getString(R.string.login_error_invalidLogin);
                break;
        }
        setLoader(false);
        cleanFields();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cleanFields() {
        loginActivityEtEmail.setText("");
        loginActivityEtPassword.setText("");
    }

    @Override
    public void onLoginSuccess() {
        setLoader(false);
        startActivity(new Intent(this, SendEmailActivity.class));
        finish();
    }
}
