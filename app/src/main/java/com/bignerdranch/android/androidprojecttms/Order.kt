package com.bignerdranch.android.androidprojecttms

data class Order(
    val idOrder: Int,
    val consumer: String,
    val product: String,
    val address: String,
    val price: Double
)