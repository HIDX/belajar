package com.example.belajar2

import com.example.belajar2.Model.Item
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiInterface {
    @get:GET("item")
    val data: Call<Item>

    @FormUrlEncoded
    @POST("item")
    fun tambahItem(
        @Field("nama") nama: String,
        @Field("harga") harga: Int?,
        @Field("jumlah") jumlah: Int?
    ): Call<Item>

    @FormUrlEncoded
    @PUT("item/{id}")
    fun ubahItem(
        @Path("id") id: Int?,
        @Field("nama") nama: String,
        @Field("harga") harga: Int?,
        @Field("jumlah") jumlah: Int?
    ): Call<Item>

    @DELETE("item/{id}")
    fun hapusItem(@Path("id") id: Int?): Call<Item>
}