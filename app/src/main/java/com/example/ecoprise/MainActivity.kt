package com.example.ecoprise

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecoprise.Adapter.EnterprisesAdapter
import com.example.ecoprise.Common.Common
import com.example.ecoprise.Interface.RetrofitServices
import com.example.ecoprise.Model.Enterprise

import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    /*private lateinit var apiClient: RetrofitClient
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = RetrofitClient()
        sessionManager = SessionManager(this)
    }*/

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: EnterprisesAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getAllEnterprises().enqueue(object : Callback<MutableList<Enterprise>> {
            override fun onFailure(call: Call<MutableList<Enterprise>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Enterprise>>, response: Response<MutableList<Enterprise>>) {
                adapter = EnterprisesAdapter(baseContext, response.body() as MutableList<Enterprise>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}