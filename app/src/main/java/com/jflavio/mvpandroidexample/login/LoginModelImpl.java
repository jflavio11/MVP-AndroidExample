/*
 * Created by JoseFlavio on 7/22/17 1:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:05 AM
 */

package com.jflavio.mvpandroidexample.login;

/**
 * Here is implemented all bussiness logic. Easy to test. Enjoy!
 */
public class LoginModelImpl implements LoginContract.LoginModel {

    private static final String EMAIL_TEST = "email@email.com";
    private static final String PASSWORD_TEST = "myPassword123";

    @Override
    public boolean isValidEmail(String email) {
        return email.contains("@");
    }

    @Override
    public boolean isValidPassword(String password) {
        return password.length() == 10;
    }

    @Override
    public boolean validateLogin(String email, String password) {
        return EMAIL_TEST.equals(email) && PASSWORD_TEST.equals(password);
    }
}