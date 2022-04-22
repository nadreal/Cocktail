package com.example.cocktail.network


import android.util.Log
import android.widget.Toast
import com.example.cocktail.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class SingleCallback<T : Result<*>?> :
    Callback<T> {

    override fun onResponse(
        call: Call<T>,
        response: Response<T>
    ) {
        val result = response.body()
        if (result == null) {
            onFailure("-99", "FAILED", null)
        } else {
            if (apiFailure(result)) {
                onFailure(result.errorCode, result.errorMsg ?: "", result)
            } else {
                onSuccess(result)
            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e("SingleCallback", "onFailure: " + t.message, t)
    }

    fun successCode(): String {
        return "0"
    }

    fun apiFailure(result: T?): Boolean {
        return result == null || successCode() != result.errorCode
    }

    fun onFailure(code: String?, message: String, response: T?) {
        Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show()
    }

    abstract fun onSuccess(response: T)

}