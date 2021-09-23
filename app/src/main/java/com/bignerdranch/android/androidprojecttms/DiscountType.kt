package com.bignerdranch.android.androidprojecttms

sealed class DiscountType(val calculate:(Int) -> String) {
    data class FlatAmount(val value: Int) : DiscountType({
        (it * value).toString()
    })
    data class RangeAmount(val startValue: Int, val endValue: Int) : DiscountType({
        ((startValue + endValue) / 2 * it).toString()
    })
    object NoDiscount : DiscountType({
        "0"
    })

    override fun toString(): String {
        return when (this) {
            is FlatAmount -> "Flat Amount"
            is RangeAmount -> "Range Amount"
            NoDiscount -> "Object discount type"
        }
    }
}
