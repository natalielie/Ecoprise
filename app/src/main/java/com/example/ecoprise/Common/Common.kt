package com.example.ecoprise.Common

import com.example.ecoprise.Interface.RetrofitServices
import com.example.ecoprise.Retrofit.RetrofitClient

object Common {
    const val BASE_URL = "https://ecoprise.azurewebsites.net"
    val retrofitService: RetrofitServices
      get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)

    //const val LOGIN_URL = "https://ecoprise.azurewebsites.net/Identity/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3DEcoClean%26redirect_uri%3Dhttps%253A%252F%252Fecoprise.azurewebsites.net%252Fauthentication%252Flogin-callback%26response_type%3Dcode%26scope%3DEcoCleanAPI%2520openid%2520profile%26state%3D3821c5aa3b2c4407b44df2f6a67b2d0f%26code_challenge%3DnmUw9MBrC_V3vRv7sAHHt20l7uPo1HhZnZEqx1bUy6U%26code_challenge_method%3DS256%26response_mode%3Dquery"
    const val POSTS_URL = "posts"
    const val LOGIN_URL = "https://ecoprise.azurewebsites.net/ClientApp/authentication/login"
    //const val ENTERPRISE_URL = ""
}