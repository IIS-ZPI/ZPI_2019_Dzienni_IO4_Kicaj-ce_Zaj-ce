package com.zpi.main;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static double getMedian(List<Rate> rateList){
        List<Double> doubleList = new ArrayList<>();

        for (Rate rate : rateList) {
            doubleList.add( rate.getMid() );
        }

        doubleList.sort( Double::compareTo );

        if(doubleList.size() % 2 == 0){
            double d1 = doubleList.get( (doubleList.size()/2) - 1 );
            double d2 = doubleList.get( ((doubleList.size()/2) + 1) - 1 );

            return (d1*d2)/2;
        }else {
            return doubleList.get( ((doubleList.size() + 1)/2) - 1  );
        }

    }
}
