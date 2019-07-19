package com.example.uasmobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasmobileprogramming.model.Item;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormUpdate extends AppCompatActivity {
    private static final String TAG = "FormUpdate";
    private ApiInterface apiInterface;
    EditText etNama, etHarga, etJumlah;
    Button btnSubmit,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Intent intent = getIntent();
        etNama = findViewById(R.id.etFormNama);
        etHarga = findViewById(R.id.etFormHarga);
        etJumlah = findViewById(R.id.etFormJumlah);
        btnSubmit = findViewById(R.id.btnFormSubmit);
        btnDelete = findViewById(R.id.btnFormDelete);
        String nama = intent.getStringExtra("nama");
        String harga = intent.getStringExtra("harga");
        String jumlah = intent.getStringExtra("jumlah");
        int id = intent.getIntExtra("id",0);
        Log.d(TAG, "onCreate: gg " + intent.getStringExtra("nama"));
        Log.d(TAG, "onCreate: " + id);
        etNama.setText(nama);
        etHarga.setText(harga);
        etJumlah.setText(jumlah);
        apiInterface = ApiNetwork.getClient().create(ApiInterface.class);
        btnSubmit.setOnClickListener(view -> updateData(id,etNama.getText().toString(),Integer.parseInt(etHarga.getText().toString()),Integer.parseInt(etJumlah.getText().toString())));
        btnDelete.setOnClickListener(view -> deleteData(id));
    }

    private void deleteData(int id) {
        Call<Item> data = apiInterface.hapusItem(id);
        data.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Toast.makeText(FormUpdate.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: jj " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(FormUpdate.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }

    private void updateData(Integer id, String nama, int harga, int jumlah) {
        Call<Item> dataCall = apiInterface.ubahItem(id,nama,harga,jumlah);
        dataCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Toast.makeText(FormUpdate.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onResponse: " + response.raw());
                onBackPressed();
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(FormUpdate.this, "Data gagal diupdate", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ",t );
            }
        });
    }
}
