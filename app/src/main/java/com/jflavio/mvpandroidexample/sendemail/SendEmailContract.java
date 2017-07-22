/*
 * Created by JoseFlavio on 7/22/17 1:15 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:15 AM
 */

package com.jflavio.mvpandroidexample.sendemail;


class SendEmailContract {

    interface View {
        void setLoader(boolean visible);
        void onError(int errorType);
        void onEmailSent();
        void logOut();
    }

    interface UserActionListener {
        void sendEmail(String from, String to, String message);
    }

    interface SendEmailModel {
        boolean validateEmail(String emailTo);
        boolean validateMessage(String message);
        boolean sendEmail(String from, String emailTo, String message);
    }

}
