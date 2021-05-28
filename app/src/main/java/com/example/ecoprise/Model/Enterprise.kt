package com.example.ecoprise.Model

import com.google.gson.annotations.SerializedName

data class Enterprise (
    @SerializedName("enterprise_id")
    var enterprise_id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("kind")
    val kind: Int,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("product")
    val product: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("client_id")
    val client_id: Int,

    )