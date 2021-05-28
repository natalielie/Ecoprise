package com.example.ecoprise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecoprise.Adapter.SessionManager
import com.example.ecoprise.Model.Request.LoginRequest
import com.example.ecoprise.Model.Response.LoginResponse
import com.example.ecoprise.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: RetrofitClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       /* apiClient = RetrofitClient()
        sessionManager = SessionManager(this)

        apiClient.getApiService()
            .login(LoginRequest(email = "s@sample.com", password = "mypassword"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()

                    if (loginResponse?.statusCode == 200 && loginResponse.client != null) {
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    } else {
                        // Error logging in
                    }
                }
            })*/

    }
}