package com.bignerdranch.android.androidprojecttms

data class Order(
    private val idOrder: Int,
    private val consumer: String,
    private val product: String,
    private val address: String,
    private val price: Double,
) {
    fun getIdOrder(): Int = idOrder
    fun getConsumer(): String = consumer
    fun getProduct(): String = product
    fun getAddress(): String = address
    fun getPrice(): Double = price
}
