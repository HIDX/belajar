package com.example.belajar2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("nama")
    @Expose
    private var nama: String? = null
    @SerializedName("harga")
    @Expose
    private var harga: String? = null
    @SerializedName("jumlah")
    @Expose
    private var jumlah: String? = null
    @SerializedName("deskripsi")
    @Expose
    private var deskripsi: String? = null
    @SerializedName("detail")
    @Expose
    private var detail: String? = null
    @SerializedName("foto")
    @Expose
    private var foto: Any? = null
    @SerializedName("created_at")
    @Expose
    private var createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
    private var updatedAt: String? = null

    fun Data(
        id: Int?,
        nama: String,
        harga: String,
        jumlah: String,
        deskripsi: String,
        detail: String,
        foto: Any,
        createdAt: String,
        updatedAt: String
    )
    {
        this.id = id
        this.nama = nama
        this.harga = harga
        this.jumlah = jumlah
        this.deskripsi = deskripsi
        this.detail = detail
        this.foto = foto
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }


    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getNama(): String? {
        return nama
    }

    fun setNama(nama: String) {
        this.nama = nama
    }

    fun getHarga(): String? {
        return harga
    }

    fun setHarga(harga: String) {
        this.harga = harga
    }

    fun getJumlah(): String? {
        return jumlah
    }

    fun setJumlah(jumlah: String) {
        this.jumlah = jumlah
    }

    fun getDeskripsi(): String? {
        return deskripsi
    }

    fun setDeskripsi(deskripsi: String) {
        this.deskripsi = deskripsi
    }

    fun getDetail(): String? {
        return detail
    }

    fun setDetail(detail: String) {
        this.detail = detail
    }

    fun getFoto(): Any? {
        return foto
    }

    fun setFoto(foto: Any) {
        this.foto = foto
    }

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setCreatedAt(createdAt: String) {
        this.createdAt = createdAt
    }

    fun getUpdatedAt(): String? {
        return updatedAt
    }

    fun setUpdatedAt(updatedAt: String) {
        this.updatedAt = updatedAt
    }
}