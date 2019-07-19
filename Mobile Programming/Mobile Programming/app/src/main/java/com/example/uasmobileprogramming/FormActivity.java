package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uasmobileprogramming.model.Item;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {

    private static final String TAG = "FormActivity";
    private ApiInterface apiInterface;
    EditText etNama, etHarga, etJumlah;
    Button btnSubmit,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNama = findViewById(R.id.etFormNama);
        etHarga = findViewById(R.id.etFormHarga);
        etJumlah = findViewById(R.id.etFormJumlah);
        btnSubmit = findViewById(R.id.btnFormSubmit);
        btnDelete = findViewById(R.id.btnFormDelete);
        btnDelete.setVisibility(View.INVISIBLE);

        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnSubmit.setOnClickListener(view -> addData(etNama.getText().toString(),Integer.parseInt(etHarga.getText().toString()),Integer.parseInt(etJumlah.getText().toString())));
    }
    public void addData(String nama, Integer harga, Integer jumlah){
        Call<Item> dataCall = apiInterface.tambahItem(nama,harga,jumlah);
        dataCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Toast.makeText(FormActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(FormActivity.this, "Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
}
