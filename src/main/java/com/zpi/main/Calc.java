package com.zpi.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calc {
    public static double getMedian(List<Rate> rateList){
        List<Double> doubleList = prepareList( rateList );

        if(doubleList.size() % 2 == 0){
            double d1 = doubleList.get( (doubleList.size()/2) - 1 );
            double d2 = doubleList.get( ((doubleList.size()/2) + 1) - 1 );

            return (d1*d2)/2;
        }else {
            return doubleList.get( ((doubleList.size() + 1)/2) - 1  );
        }

    }

    public static List<Double> getDominants(List<Rate> rateList){
        List<Double> doubleList = prepareList( rateList );

        HashMap<Double, Integer> hashMap = new HashMap<>();

        for (Double aDouble : doubleList) {
            if(!hashMap.containsKey( aDouble )){
                hashMap.put( aDouble, 1 );
            }else {
                int temp = hashMap.get(aDouble);
                hashMap.remove( aDouble );
                hashMap.put( aDouble, temp + 1 );
            }
        }

        int maxVal = 0;

        for (Double aDouble : doubleList) {
            int temp = hashMap.get( aDouble );
            if(maxVal == 0){
                maxVal = temp;
            }else if(maxVal < temp){
                maxVal = temp;
            }
        }

        List<Double> dominants = new ArrayList<>();
        for (Double aDouble : doubleList) {
            if(maxVal == hashMap.get( aDouble )){
                dominants.add( aDouble );
            }
        }

        return dominants;
    }

    public static double getStandardDeviation(List<Rate> rateList){
        List<Double> doubleList = prepareList( rateList );

        double avarage = getAvarage(doubleList);

        double standardDeviation = 0;

        for (Double aDouble : doubleList) {
            standardDeviation += Math.pow( (aDouble - avarage), 2 );
        }

        return Math.sqrt( standardDeviation / (double)doubleList.size() );
    }

    private static double getAvarage(List<Double> doubleList) {
        double sum = 0;
        for (Double aDouble : doubleList) {
            sum += aDouble;
        }

        return sum/(double)doubleList.size();
    }

    private static List<Double> prepareList(List<Rate> rateList) {
        List<Double> doubleList = new ArrayList<>();

        getListOfRate( rateList, doubleList );

        doubleList.sort( Double::compareTo );
        return doubleList;
    }

    private static void getListOfRate(List<Rate> rateList, List<Double> doubleList) {
        for (Rate rate : rateList) {
            doubleList.add( rate.getMid() );
        }
    }
}
