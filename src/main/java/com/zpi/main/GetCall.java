package com.zpi.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface GetCall {
    @GET("rates/a/gbp/last/7")
    Call<Quotations> loadRatesForSpecyfiedNumberOfDays();
}
