/*
 * Created by JoseFlavio on 7/22/17 1:25 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:25 AM
 */

package com.jflavio.mvpandroidexample.sendemail;


import com.jflavio.mvpandroidexample.utils.ErrorConstants;

class SendEmailPresenter implements SendEmailContract.UserActionListener {

    private SendEmailContract.View view;
    private SendEmailModelImpl model;

    SendEmailPresenter(SendEmailContract.View view) {
        this.view = view;
        this.model = new SendEmailModelImpl();
    }

    @Override
    public void sendEmail(String from, String to, String message) {

        if (!this.model.validateEmail(to)) {
            this.view.onError(ErrorConstants.ERROR_INVALID_EMAIL);
            this.view.cleanFields();
            return;
        }

        if (!this.model.validateMessage(message)) {
            this.view.onError(ErrorConstants.ERROR_MESSAGE_TOO_LONG);
            return;
        }

        if (this.model.sendEmail(from, to, message)) {
            this.view.setLoader(false);
            this.view.cleanFields();
            this.view.onEmailSent();
        } else {
            this.view.onError(ErrorConstants.ERROR_SERVER);
        }

    }
}
