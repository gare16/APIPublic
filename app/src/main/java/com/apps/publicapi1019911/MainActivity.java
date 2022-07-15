package com.apps.publicapi1019911;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.apps.publicapi1019911.API.Api;
import com.apps.publicapi1019911.API.Service;
import com.apps.publicapi1019911.Adapter.AnimeAdapter;
import com.apps.publicapi1019911.model.AnimeModel;
import com.apps.publicapi1019911.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AnimeAdapter animeAdapter;
    private List<AnimeModel> dbItems = new ArrayList<>();

    @BindView(R.id.contentAPI)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List Anime");

        animeAdapter = new AnimeAdapter(this, dbItems);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(animeAdapter);
        loadAPIAnime();

    }
    private void loadAPIAnime() {

        Service api = Api.getClient().create(Service.class);

        Call<ResponseModel> call = api.getAnime();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Boolean message = response.body().isSuccess();

                if (message == Boolean.TRUE) {
                    dbItems = response.body().data;
                    System.out.println("STATUS data " + dbItems);
                    animeAdapter = new AnimeAdapter(MainActivity.this, dbItems);
                    recyclerView.setAdapter(animeAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.e("Error", "Error msg: ", t);
                Toast.makeText(MainActivity.this, "No Connection !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}