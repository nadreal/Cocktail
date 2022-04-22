package com.example.cocktail.network

class Result<T> {
    var errorCode: String? = null
    var errorMsg: String? = null
    var data: T? = null
}