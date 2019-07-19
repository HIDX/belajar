package com.example.belajar2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("error")
    @Expose
    private var error: Boolean? = null
    @SerializedName("message")
    @Expose
    private var message: String? = null
    @SerializedName("data")
    @Expose
    private var data: List<Data>? = null

    fun getError(): Boolean? {
        return error
    }

    fun setError(error: Boolean?) {
        this.error = error
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun getData(): List<Data>? {
        return data
    }

    fun setData(data: List<Data>) {
        this.data = data
    }
}