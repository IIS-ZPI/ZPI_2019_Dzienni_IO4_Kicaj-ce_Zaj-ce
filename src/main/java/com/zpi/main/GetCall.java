package com.zpi.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetCall {
    @GET("rates/a/{currency}/{from}/{to}/")
    Call<Quotations> loadRatesForSpecyfiedNumberOfDays(@Path("currency") String currency, @Path("from") String fromData, @Path("to") String toData,
                                                       @Query("format") String format);
}
