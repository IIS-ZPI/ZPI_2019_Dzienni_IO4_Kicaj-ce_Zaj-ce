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

            return (d1+d2)/2;
        }else {
            return doubleList.get( ((doubleList.size() + 1)/2) - 1  );
        }
    }

    public static int getGrowthSession(List<Rate> rateList)
    {
        int counter = -1;
        boolean czyMalaloPrzedChwila = false;
        double temp_value = rateList.get(0).getMid(); // przypisujemy pierwszy element

        if(temp_value < rateList.get(1).getMid())
        {
            counter++;
        }

        for (Rate r: rateList
        ) {
      //      System.out.println("Gr " + r.getMid());
            if(r.getMid() < temp_value) {
                temp_value = r.getMid();
                czyMalaloPrzedChwila = true;
            }
            else if(r.getMid() == temp_value)
            {
                if(czyMalaloPrzedChwila) {
                    counter++;
                    czyMalaloPrzedChwila = false;
                }
            }
            else
            {
                temp_value = r.getMid();
                if(czyMalaloPrzedChwila)
                {
                    counter++;
                    czyMalaloPrzedChwila = false;
                }
            }
        }

        return counter;
    }

    public static int getDecreasedSession(List<Rate> rateList)
    {
        int counter = -1;
        boolean czyZwiekszaloSiePrzedChwila = false;
        double temp_value = rateList.get(0).getMid(); // przypisujemy pierwszy element

        if(temp_value > rateList.get(1).getMid())
        {
            counter++;
        }
        for (Rate r: rateList
        ) {
         //   System.out.println("Dc " + r.getMid());
            if(r.getMid() > temp_value) {
                temp_value = r.getMid();
                czyZwiekszaloSiePrzedChwila = true;
            }
            else if(r.getMid() == temp_value)
            {

                counter++;
                czyZwiekszaloSiePrzedChwila = false;
            }
            else
            {
                temp_value = r.getMid();
                if(czyZwiekszaloSiePrzedChwila)
                {
                    counter++;
                    czyZwiekszaloSiePrzedChwila = false;
                }
            }
        }

        return counter;
    }

    public static int getNoChangesSession(List<Rate> rateList)
    {
        int counter = -1;
        boolean czyByloStalePrzedChwila = false;
        double temp_value = rateList.get(0).getMid(); // przypisujemy pierwszy element
        for (Rate r: rateList
        ) {
            if(r.getMid() == temp_value) {
                temp_value = r.getMid();
                czyByloStalePrzedChwila = true;
            }
            else
            {
                temp_value = r.getMid();
                if(czyByloStalePrzedChwila)
                {
                    counter++;
                    czyByloStalePrzedChwila = false;
                }
            }
        }

        return counter;
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

        return Math.sqrt( standardDeviation / ((double)doubleList.size() - 1) ); // n-1, odchylenie standardowe z próby
    }

    private static double getAvarage(List<Double> doubleList) {
        double sum = 0;
        for (Double aDouble : doubleList) {
            sum += aDouble;
        }

        return sum/(double)doubleList.size();
    }

    public static double getCoefficientOfVariation(List<Rate> rateList){
        List<Double> doubleList = prepareList( rateList );

        double avarage = getAvarage(doubleList);
        double deviation = getStandardDeviation(rateList);

        return (double)deviation/avarage*100; // odchylenie standardowe z próby / średnia arytmetyczna z próby. - podawane w procentach
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

    public static void getChangeSession(String name, String name2, List<Rate> rateList, List<Rate> rateList2) {
        List<Double> doubleList = new ArrayList<>();
        getListOfRate( rateList, doubleList );
        List<Double> doubleList2 = new ArrayList<>();
        getListOfRate( rateList2, doubleList2 );
        List<Double> changes = new ArrayList<>();
        List<Double> changes2 = new ArrayList<>();

        if(doubleList.size() !=  doubleList2.size()) {
            System.out.println("Rozkład zmian - Porównywane waluty mają różną długość.");
        } else {
            for (int i = 1; i < doubleList.size(); i++) {
                changes.add((double) doubleList.get(i) - doubleList.get(i - 1));
                changes2.add((double) doubleList2.get(i) - doubleList2.get(i - 1));
            }
            System.out.println("Rozkład zmian - waluta " + name + ": " + changes);
            System.out.println("Rozkład zmian - waluta " + name2 + ": " + changes2);
        }
    }
}
