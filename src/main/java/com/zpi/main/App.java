package com.zpi.main;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );
        ApiCommunication apiCommunication = new ApiCommunication();
        System.out.println(apiCommunication.getSessions("2012-01-02", "2012-02-01", "gbp").toString());
    }
}
