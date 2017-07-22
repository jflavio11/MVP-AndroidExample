/*
 * Created by JoseFlavio on 7/22/17 1:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 12:59 AM
 */

package com.jflavio.mvpandroidexample.login;

import com.jflavio.mvpandroidexample.utils.ErrorConstants;

class LoginPresenter implements LoginContract.UserActionListener {

    private LoginContract.View view;
    private LoginModelImpl loginModel;

    LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void login(String username, String password) {
        this.view.setLoader(true);

        if(!this.loginModel.isValidEmail(username)){
            this.view.showError(ErrorConstants.ERROR_INVALID_EMAIL);
            return;
        }

        if(!this.loginModel.isValidPassword(password)){
            this.view.showError(ErrorConstants.ERROR_INVALID_PASSWORD);
            return;
        }

        if(!this.loginModel.validateLogin(username, password)){
            this.view.showError(ErrorConstants.ERROR_INVALID_LOGIN);
        } else {
            this.view.onLoginSuccess();
        }

    }
}
