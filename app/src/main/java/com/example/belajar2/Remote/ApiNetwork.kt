package com.example.belajar2.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiNetwork {
    private var retrofit: Retrofit? = null
    fun getClient(baseUrl: String) {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        val base_url = "http://api.sharkhomedesign.com/public/"
    }
}


//   null val client: Retrofit?
//        get() {
//            if (retrofit == null) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(base_url)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return retrofit
//        }

    //    private var retrofit:Retrofit?=null
//    fun getclient(baseUrl:String):Retrofit{
//        if (retrofit==null)
//        {
//            retrofit= Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//
//        return retrofit!!
//    }
