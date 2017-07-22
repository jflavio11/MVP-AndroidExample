/*
 * Created by JoseFlavio on 7/22/17 1:24 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:24 AM
 */

package com.jflavio.mvpandroidexample.sendemail;


public class SendEmailModelImpl implements SendEmailContract.SendEmailModel {
    @Override
    public boolean validateEmail(String emailTo) {
        return emailTo.contains("@");
    }

    @Override
    public boolean validateMessage(String message) {
        return message.length() < 100;
    }

    @Override
    public boolean sendEmail(String from, String emailTo, String message) {
        return true;
    }
}
