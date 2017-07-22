/*
 * Created by JoseFlavio on 7/22/17 1:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 12:59 AM
 */

package com.jflavio.mvpandroidexample.login;

/**
 * Interfaces for Model-View-Presenter pattern. {@link LoginActivity} must implements {@link View}, {@link LoginPresenter} must
 * implements {@link UserActionListener} and {@link LoginModelImpl} must implements {@link LoginModel}.
 *
 * Remember that user interacts with application graphic interface through activities, fragments, dialogs, etc. These implement View
 * interface for communication with the Presenter that is going to be the intermediary between The Model which contains all bussines logic
 * and all GUI interactions.
 */
class LoginContract {

    interface View {
        void initView();
        void setLoader(boolean visible);
        void showError(int errorType);
        void onLoginSuccess();
    }

    interface UserActionListener {
        void login(String username, String password);
    }

    interface LoginModel {
        boolean isValidEmail(String email);
        boolean isValidPassword(String password);
        boolean validateLogin(String email, String password);
    }

}