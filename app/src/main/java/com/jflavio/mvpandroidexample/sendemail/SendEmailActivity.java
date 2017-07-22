/*
 * Created by JoseFlavio on 7/22/17 1:06 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/21/17 9:03 PM
 */

package com.jflavio.mvpandroidexample.sendemail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jflavio.mvpandroidexample.R;
import com.jflavio.mvpandroidexample.login.LoginActivity;
import com.jflavio.mvpandroidexample.utils.ErrorConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendEmailActivity extends AppCompatActivity implements SendEmailContract.View {

    @BindView(R.id.sendEmailActivity_et_email)
    EditText sendEmailActivityEtEmail;
    @BindView(R.id.sendEmailActivity_et_message)
    EditText sendEmailActivityEtMessage;
    @BindView(R.id.sendEmailActivity_btn_send)
    Button sendEmailActivityBtnSend;
    @BindView(R.id.sendEmailActivity_pb)
    ProgressBar sendEmailActivityPb;

    private SendEmailContract.UserActionListener userActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItem_logout:
                logOut();
                break;
        }

        return true;
    }

    private void initView() {
        if (this.userActionListener == null) this.userActionListener = new SendEmailPresenter(this);
        sendEmailActivityBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoader(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        userActionListener.sendEmail("currentEmail@email.com", sendEmailActivityEtEmail.getText().toString(),
                                sendEmailActivityEtMessage.getText().toString());
                    }
                }, 3000);
            }
        });
    }

    @Override
    public void setLoader(boolean visible) {
        sendEmailActivityPb.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onError(int errorType) {
        String text = getString(R.string.login_error_unknown);
        switch (errorType){
            case ErrorConstants.ERROR_INVALID_EMAIL:
                text = getString(R.string.login_error_invalidEmail);
                break;
            case ErrorConstants.ERROR_MESSAGE_TOO_LONG:
                text = getString(R.string.email_error_messageLong);
                break;
        }
        setLoader(false);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailSent() {
        Toast.makeText(this, getString(R.string.email_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cleanFields() {
        sendEmailActivityEtEmail.setText("");
        sendEmailActivityEtMessage.setText("");
    }

    @Override
    public void logOut() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
