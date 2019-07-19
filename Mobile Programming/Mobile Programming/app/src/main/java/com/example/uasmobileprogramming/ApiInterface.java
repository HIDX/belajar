package com.example.uasmobileprogramming;

import android.renderscript.Sampler;

import com.example.uasmobileprogramming.model.Data;
import com.example.uasmobileprogramming.model.Item;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("item")
    Call<Item> getData();
    @FormUrlEncoded
    @POST("item")
    Call<Item> tambahItem(@Field("nama") String nama,
                          @Field("harga") Integer harga,
                          @Field("jumlah") Integer jumlah);
    @FormUrlEncoded
    @PUT("item/{id}")
    Call<Item> ubahItem(@Path("id") Integer id,
                        @Field("nama") String nama,
                        @Field("harga") Integer harga,
                        @Field("jumlah") Integer jumlah
                        );

    @DELETE("item/{id}")
    Call<Item> hapusItem(@Path("id") Integer id);
}