package com.a20112981.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("people")
    Call<Response1> getPeople();

    @GET("planets")
    Call<PlanetsModel> getPlanets();

    //@GET("planets/{id}")
    //Call<PlanetsModel> getPlanets(@Path("id") int id);

}
