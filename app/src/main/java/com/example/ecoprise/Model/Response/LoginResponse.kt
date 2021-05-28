package com.example.ecoprise.Model.Response

import com.example.ecoprise.Model.Client
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status_code")
    var statusCode: Int,

    @SerializedName("auth_token")
    var authToken: String,

    @SerializedName("user")
    var client: Client
)