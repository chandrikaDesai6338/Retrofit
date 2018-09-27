package com.a20112981.retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    StarAdapter usersAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Results> info;
    ApiInterface apiInterface;
    List<Planets> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        CallPeople();
        CallPlanets();

    }

    public void CallPeople() {
        Call<Response1> call = apiInterface.getPeople();
        call.enqueue(new Callback<Response1>() {
            @Override
            public void onResponse(Call<Response1> call, Response<Response1> response) {
                info = response.body().getResults();
                Log.d(TAG, "Number of Charater's info received: " + info.size());
                setDataInRecyclerView(info);

            }

            @Override
            public void onFailure(Call<Response1> call, Throwable t) {

            }
        });

    }

    public void CallPlanets() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PlanetsModel> call = apiInterface.getPlanets();
        call.enqueue(new Callback<PlanetsModel>() {
            @Override
            public void onResponse(Call<PlanetsModel> call, Response<PlanetsModel> response) {
                planets = response.body().getResults();
                Log.d(TAG, "Number of planets info received: " + planets.size());
            }

            @Override
            public void onFailure(Call<PlanetsModel> call, Throwable t) {

            }
        });
    }

    private void setDataInRecyclerView(List<Results> info) {

        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
        usersAdapter = new StarAdapter(MainActivity.this, info, planets);
        recyclerView.setAdapter(usersAdapter); // set the Adapter to RecyclerView
    }

}
