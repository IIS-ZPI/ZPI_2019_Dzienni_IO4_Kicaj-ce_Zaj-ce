package com.zpi.main;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ApiCommunicationTest {

    DateFormat df;
    Date date;
    ApiCommunication apiCommunication;

    @Before
    public void init(){
        df = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        apiCommunication = new ApiCommunication();
    }

    @Test
    public void when_Given_Five_Days_Should_Return_5_Values() throws InterruptedException {
        int days=5;
        int numberOfValues=5+1;//+1 because function returns 5 values and 1 currency name
        String temp =apiCommunication.getSessions(df.format(DateUtils.addDays(new Date(),days*(-1)-2)), df.format(date), "gbp").toString();
        String result[] = temp.split("\n");
        Assert.assertEquals(numberOfValues,result.length);
    }


}