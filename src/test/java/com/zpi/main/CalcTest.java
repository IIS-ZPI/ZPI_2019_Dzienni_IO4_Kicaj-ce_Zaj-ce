package com.zpi.main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalcTest {

    Rate[] testdata;
    List<Rate> data;
    double medianResult;
    int counterForGrowthSession;
    int counterForDecreasedSession;
    int counterForNoChangesSession;
    double standardDeviation;
    @Before
    public void init(){
        testdata = new Rate[10];
        data = new ArrayList<Rate>();
        makeTestData();


    }

    @Test
    public void median_should_return_the_correct_value(){

        Double result=Calc.getMedian(data);

        Assert.assertEquals(medianResult,result.doubleValue(),0.001);
        medianResult=5.2;
        data.remove(data.size()-1);
        result=Calc.getMedian(data);
        Assert.assertEquals(medianResult,result.doubleValue(),0.001);
    }
    @Test
    public void growthSession_for_test_data_should_return_correct_value(){
        int result=Calc.getGrowthSession(data);

        Assert.assertEquals(counterForGrowthSession,result);

    }
    @Ignore
    @Test
    public void decreasedSession_for_test_data_should_return_correct_value(){
        int result=Calc.getDecreasedSession(data);

        Assert.assertEquals(counterForDecreasedSession,result);
    }

    @Test
    public void noChangesSession_for_test_data_should_return_correct_value(){
        int result=Calc.getNoChangesSession(data);

        Assert.assertEquals(counterForNoChangesSession,result);

    }
    @Test
    public void standardDeviation_for_test_data_should_return_correct_value(){
        double result=Calc.getStandardDeviation(data);

        Assert.assertEquals(standardDeviation,result,0.0000001);
    }


    public void makeTestData(){
        testdata[0]=new Rate(4.5);
        testdata[1]=new Rate(5.2);
        testdata[2]=new Rate(6.3);
        testdata[3]=new Rate(5.6);
        testdata[4]=new Rate(5.1);
        testdata[5]=new Rate(5.1);
        testdata[6]=new Rate(4.2);
        testdata[7]=new Rate(7.8);
        testdata[8]=new Rate(8.2);
        testdata[9]=new Rate(9.6);
        for(int i =0;i<10;i++) {
            data.add(testdata[i]);
        }
        medianResult=5.4;
        counterForGrowthSession=2;
        counterForDecreasedSession=2;
        counterForNoChangesSession=1;
        standardDeviation=1.7883574089712106;
    }
}