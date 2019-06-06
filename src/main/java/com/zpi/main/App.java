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
        System.out.println( "Hello World!" );
        ApiCommunication apiCommunication = new ApiCommunication();
        System.out.println(apiCommunication.getSessions(df.format(DateUtils.addDays(new Date(),-8)), df.format(date), "gbp").toString());
    }
}
