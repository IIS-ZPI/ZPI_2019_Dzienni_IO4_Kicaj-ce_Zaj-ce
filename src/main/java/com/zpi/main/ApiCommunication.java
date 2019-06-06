package com.zpi.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCommunication {

    private static final String baseUrl = "http://api.nbp.pl/api/exchangerates/";
    private volatile Quotations q;

    public Quotations getSessions(int numbOfDays, String currency) throws InterruptedException {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();

        GetCall getCall = retrofit.create(GetCall.class);

        Call<Quotations> response = getCall.loadRatesForSpecyfiedNumberOfDays(currency, String.valueOf(numbOfDays), "json");

        response.enqueue(new Callback<Quotations>() {
            @Override
            public void onResponse(Call<Quotations> call, Response<Quotations> response) {
                if(response.isSuccessful()){
                    q = response.body();
                }else{
                    q = new Quotations();
                    System.out.println("fail");
                }
            }

            @Override
            public void onFailure(Call<Quotations> call, Throwable throwable) {
                q = new Quotations();
                System.out.println("fail");
            }
        });

        while (q == null){}

        return q;
    }
}
