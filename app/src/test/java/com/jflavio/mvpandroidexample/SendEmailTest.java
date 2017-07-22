/*
 * Created by JoseFlavio on 7/22/17 1:43 AM
 * Copyright (c) 2017. All rights reserved.
 * Contact: jflavio90@gmail.com
 *
 * Last modified 7/22/17 1:43 AM
 */

package com.jflavio.mvpandroidexample;


import com.jflavio.mvpandroidexample.sendemail.SendEmailModelImpl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class SendEmailTest {

    private SendEmailModelImpl model;

    @Before
    public void prepateTest(){
        model = new SendEmailModelImpl();
    }

    @Test
    public void validMessageTest(){
        String message = "asd ksjdlksajd lkasjdla ksjdlaskjdlasj dalskdjaskldjskdjfnsdknfslj salkdjaslk djasldkjaslkd a;sldkasldk ;alsdk;" +
                "lasdk;alsdk;alsdk;asldk;asldka;s kda;sldk as;ldk asldasldhkas fdsjnfdsjfslnfsdkjfdjf sdjfdslkfj dlskfjsdlkfjsdlk " +
                "fsdklfjsdlkfjsdlkfjsd lkfjsdlkjf sdlkfjsdmcksdfsdcds klsdjgjfdbgndfjkk jfslaeoqiwe9qeo fidlkjsdfo isfljsdlsdfj alkfjsldf" +
                " wer jqioefsdklfjsdkfj sdf sdfk sdfk sdf sdfj sdklfjsdfisdjf sdlkfjsdlkfjsdflksd";

        Assert.assertFalse(model.validateMessage(message));
    }

}
