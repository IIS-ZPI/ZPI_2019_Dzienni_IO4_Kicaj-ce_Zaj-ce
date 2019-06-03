package com.zpi.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String baseUrl = "http://api.nbp.pl/api/exchangerates/";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();

        GetCall getCall = retrofit.create(GetCall.class);

        Call<Quotations> response = getCall.loadRatesForSpecyfiedNumberOfDays();

        response.enqueue(new Callback<Quotations>() {
            @Override
            public void onResponse(Call<Quotations> call, Response<Quotations> response) {
                if(response.isSuccessful()){
                    Quotations quotations = response.body();
                    quotations.toString();
                }

                System.out.println(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Quotations> call, Throwable throwable) {
                System.out.println("fail");
            }
        });
    }
}
