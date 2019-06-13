package com.zpi.main;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = new Date();

    public static void main( String[] args ) throws InterruptedException {
        ApiCommunication apiCommunication = new ApiCommunication();
     //   System.out.println(apiCommunication.getSessions(df.format(DateUtils.addDays(new Date(),-8)), df.format(date), "gbp").toString());
        Quotations quotations = apiCommunication.getSessions(df.format(DateUtils.addDays(new Date(),-30)), df.format(date), "gbp");
        System.out.println(Calc.getMedian( quotations.getRates() ));
        System.out.println(Calc.getDominants( quotations.getRates() ).toString());
        System.out.println(Calc.getStandardDeviation( quotations.getRates() ));
        System.out.println("Ilosc sesji wzrostowych: " + Calc.getGrowthSession(quotations.getRates()));
        System.out.println("Ilosc sesji malejacych: " + Calc.getDecreasedSession(quotations.getRates()));
        System.out.println("Ilosc sesji bez zmian: " + Calc.getNoChangesSession(quotations.getRates()));
    }
}
