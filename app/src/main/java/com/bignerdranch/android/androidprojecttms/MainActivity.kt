package com.bignerdranch.android.androidprojecttms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    val discount = Discount(
        "Project",
        "Good project",
        1,
        "https://im0-tub-by.yandex.net/i?id=eaa2b044794b726227846dda9669ffe9&n=13",
        "https://github.com/AleksandrKunevich/AndroidProjectTMS",
        DiscountType.RangeAmount(3, 9)
    )
    println(discount)
    val discount2 = discount.copy()
    println("Сравнение (==): ${discount == discount2}")
    discount2.discountType = DiscountType.FlatAmount(5)
    println(discount)
    println(discount2)
    val discount3 = discount2.copy()
    discount3.discountType = DiscountType.NoDiscount
    println(discount3)
    println(discount.discountType.calculate(5))
    println(discount2.discountType.calculate(5))
    println(discount3.discountType.calculate(5))
}