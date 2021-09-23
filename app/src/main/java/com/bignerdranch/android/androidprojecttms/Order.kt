package com.bignerdranch.android.androidprojecttms

data class Order(
    val idOrder: Int,
    val consumer: String,
    val product: String,
    val address: String,
    val price: Double
) {
//    fun getIdOrder(): Int = idOrder
//    fun getConsumer(): String = consumer
//    fun getProduct(): String = product
//    fun getAddress(): String = address
//    fun getPrice(): Double = price
}
