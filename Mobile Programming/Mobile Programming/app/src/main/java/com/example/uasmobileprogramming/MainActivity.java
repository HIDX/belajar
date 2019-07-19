package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uasmobileprogramming.model.Data;
import com.example.uasmobileprogramming.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ApiInterface apiInterface;
    private List<Data> dataList = new ArrayList<>();
    private RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter();
    FloatingActionButton btnFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recycleViewAdapter);
        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnFloat = findViewById(R.id.btnMainFloating);

        btnFloat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,FormActivity.class)));

        getItem();

        recycleViewAdapter.setOnClickListener(position -> {
            Data data = dataList.get(position);
            Intent intent = new Intent(MainActivity.this, FormUpdate.class);
            intent.putExtra("nama", data.getNama());
            intent.putExtra("harga", String.valueOf(data.getHarga()));
            intent.putExtra("jumlah", String.valueOf(data.getJumlah()));
            intent.putExtra("id", data.getId());
            Log.d(TAG, "onCreate: " + data.getId());
            startActivity(intent);
        });
    }

    public void getItem(){
        Call<Item> dataCall = apiInterface.getData();
        dataCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                List<Data> items = response.body().getData();
                recycleViewAdapter.setDataList(items);
                dataList.addAll(items);
                Log.d(TAG, "onResponse: gg " + dataList);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        recycleViewAdapter.clearDataList(dataList);
        getItem();
    }
}
