package com.example.ecoprise.Interface

import com.example.ecoprise.Common.Common
import com.example.ecoprise.Model.Enterprise
import com.example.ecoprise.Model.Movie
import com.example.ecoprise.Model.Request.LoginRequest
import com.example.ecoprise.Model.Response.LoginResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET;

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>

    @POST(Common.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("api/client/getAllEnterprisesInSystem")
    fun getAllEnterprises(): Call<MutableList<Enterprise>>
}