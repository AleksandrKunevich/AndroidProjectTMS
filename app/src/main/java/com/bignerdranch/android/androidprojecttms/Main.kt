package com.bignerdranch.android.androidprojecttms

fun main() {
    val orderOne = Order(
        1,
        "Petya",
        "Notebook",
        "Minsk",
        999.99
    )
    val orderTwo = Order(
        2,
        "Katya",
        "Smart watch",
        "Ostrovec",
        50.0
    )
    val orderTree = Order(
        3,
        "Irina Viktorovna",
        "TV",
        "Moscow",
        2499.99
    )
    val listOrders = listOf(orderOne, orderTwo, orderTree)
    val deliveryVozim = Delivery.VozimBy(1)
    val deliveryDpd = Delivery.DpdBy(2)
    val deliveryBox = Delivery.BoxAgentCom(3)
    val arrayDelivery = arrayOf(deliveryBox, deliveryDpd, deliveryVozim)
    println(deliveryBox)
    deliveryBox.deliver(orderOne)
}