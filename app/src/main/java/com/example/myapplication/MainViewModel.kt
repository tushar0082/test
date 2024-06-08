package com.example.myapplication

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class MainViewModel: ViewModel() {

    private val _assetList = MutableLiveData<List<DataItem>>()
    val assetList: LiveData<List<DataItem>> get() = _assetList

    fun getCoinData(context: Context) {
        val mRequestQueue = Volley.newRequestQueue(context)
        val url = "https://api.coincap.io/v2/assets"

        val mStringRequest = StringRequest(Request.Method.GET, url, { response ->
            val gson = Gson()
            val assetResponse = gson.fromJson(response, Response::class.java)

            if (assetResponse.data != null) {
                _assetList.postValue(assetResponse.data as List<DataItem>?)
            }

        }, { error ->
            Log.i("Error", "Error: $error")
        })

        mRequestQueue.add(mStringRequest)
    }
}