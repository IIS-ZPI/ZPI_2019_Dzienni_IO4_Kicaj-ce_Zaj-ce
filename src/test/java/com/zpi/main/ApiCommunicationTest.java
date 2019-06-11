package com.zpi.main;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        int numberOfValues=5;
        List<Rate> result=apiCommunication.getSessions(df.format(DateUtils.addDays(new Date(),days*(-1)-2)), df.format(date), "gbp").getRates();
        Assert.assertEquals(numberOfValues,result.size());
    }
    @Test
    public void when_Given_Specified_Days_Should_Return_Specified_Values() throws InterruptedException {

        String fromDate="2019-06-06";
        String toDate="2019-06-11";
        List<Rate> result =apiCommunication.getSessions(fromDate, toDate, "gbp").getRates();
        List<Double> expectedResult= new ArrayList<Double>();
        expectedResult.add(4.8274);
        expectedResult.add(4.8270);
        expectedResult.add(4.7897);
        for(int i=0;i<3;i++){
            Assert.assertEquals(expectedResult.get(i).doubleValue(), result.get(i).getMid(),0.001);

        }
    }
    @Test(expected = NullPointerException.class)
    public void when_Given_Wrong_Argument_Should_Throw_NullPointerException() throws InterruptedException {
        String fromDate="2019-06-06";
        String toDate="wrong";
        apiCommunication.getSessions(fromDate, toDate, "gbp").toString();
    }


}
