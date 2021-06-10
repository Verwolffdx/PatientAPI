package com.datwhite.api;

import com.datwhite.entity.PatientRecordBody;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SiMedApi {
    @POST("api/Web/recordWithoutCaptcha/")
    Call<Integer> recording(@Body PatientRecordBody patientRecordBody);

    @GET("api/Web/SendRand/{IDR}")
    Call<String> getKey(@Path("IDR") int IDR);

    @GET("api/Web/confirmation/{IDR}/{KEY}")
    Call<Integer> confirmation(@Path("IDR") int IDR, @Path("KEY") int KEY);
}
