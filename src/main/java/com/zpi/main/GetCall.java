package com.zpi.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetCall {
    @GET("rates/a/gbp/last/{days}/")
    Call<Quotations> loadRatesForSpecyfiedNumberOfDays(@Path("days") String numberOfDays, @Query("format") String format);
}
