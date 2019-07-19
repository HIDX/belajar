package com.example.belajar2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.belajar2.Model.Item
import com.example.belajar2.Remote.ApiNetwork
import com.example.myapp.Remote.IMyAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormActivity : AppCompatActivity() {
    private var apiInterface: ApiInterface? = null
    internal lateinit var etNama: EditText
    internal lateinit var etHarga: EditText
    internal lateinit var etJumlah: EditText
    internal lateinit var btnSubmit: Button
    internal lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etNama = findViewById(R.id.etFormNama)
        etHarga = findViewById(R.id.etFormHarga)
        etJumlah = findViewById(R.id.etFormJumlah)
        btnSubmit = findViewById(R.id.btnFormSubmit)
        btnDelete = findViewById(R.id.btnFormDelete)
        btnDelete.visibility = View.INVISIBLE

//        apiInterface = ApiNetwork.getClient().create(ApiInterface::class.java)
        btnSubmit.setOnClickListener { view ->
            addData(
                etNama.text.toString(),
                Integer.parseInt(etHarga.text.toString()),
                Integer.parseInt(etJumlah.text.toString())
            )
        }
    }

    fun addData(nama: String, harga: Int?, jumlah: Int?) {
        val dataCall = apiInterface!!.tambahItem(nama, harga, jumlah)
        dataCall.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                Toast.makeText(this@FormActivity, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onResponse: " + response.raw())
                onBackPressed()
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Toast.makeText(this@FormActivity, "Data gagal ditambahkan", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "onFailure: ", t)
            }
        })
    }

    companion object {

        private val TAG = "FormActivity"
    }
}