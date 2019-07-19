package com.example.belajar2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.belajar2.Model.Item
import com.example.belajar2.Remote.ApiNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormUpdate : AppCompatActivity() {
    private var apiInterface: ApiInterface? = null
    internal lateinit var etNama: EditText
    internal lateinit var etHarga: EditText
    internal lateinit var etJumlah: EditText
    internal lateinit var btnSubmit: Button
    internal lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val intent = intent
        etNama = findViewById(R.id.etFormNama)
        etHarga = findViewById(R.id.etFormHarga)
        etJumlah = findViewById(R.id.etFormJumlah)
        btnSubmit = findViewById(R.id.btnFormSubmit)
        btnDelete = findViewById(R.id.btnFormDelete)
        val nama = intent.getStringExtra("nama")
        val harga = intent.getStringExtra("harga")
        val jumlah = intent.getStringExtra("jumlah")
        val id = intent.getIntExtra("id", 0)
        Log.d(TAG, "onCreate: gg " + intent.getStringExtra("nama")!!)
        Log.d(TAG, "onCreate: $id")
        etNama.setText(nama)
        etHarga.setText(harga)
        etJumlah.setText(jumlah)
       //apiInterface = ApiNetwork.getClient().create(ApiInterface::class.java)
        btnSubmit.setOnClickListener { view ->
            updateData(
                id,
                etNama.text.toString(),
                Integer.parseInt(etHarga.text.toString()),
                Integer.parseInt(etJumlah.text.toString())
            )
        }
        btnDelete.setOnClickListener { view -> deleteData(id) }
    }

    private fun deleteData(id: Int) {
        val data = apiInterface!!.hapusItem(id)
        data.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                Toast.makeText(this@FormUpdate, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onResponse: jj " + response.raw())
                onBackPressed()
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Toast.makeText(this@FormUpdate, "Data gagal dihapus", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    private fun updateData(id: Int?, nama: String, harga: Int, jumlah: Int) {
        val dataCall = apiInterface!!.ubahItem(id, nama, harga, jumlah)
        dataCall.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                Toast.makeText(this@FormUpdate, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onResponse: " + response.raw())
                onBackPressed()
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Toast.makeText(this@FormUpdate, "Data gagal diupdate", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    companion object {
        private val TAG = "FormUpdate"
    }
}