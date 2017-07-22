/*
 * Created by JoseFlavio on 7/22/17 1:11 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:11 AM
 */

package com.jflavio.mvpandroidexample;


import com.jflavio.mvpandroidexample.login.LoginModelImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    private LoginModelImpl loginModel;

    @Before
    public void prepareTest(){
        loginModel = new LoginModelImpl();
    }

    @Test
    public void validEmailTest(){
        Assert.assertFalse(loginModel.isValidEmail("email lala"));
    }

    @Test
    public void validPasswordTest(){
        Assert.assertFalse(loginModel.isValidPassword("pass"));
    }

}
