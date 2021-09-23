package com.bignerdranch.android.androidprojecttms

sealed class DiscountType {
    data class FlatAmount(val value: Int): DiscountType()
    data class RangeAmount(val startValue: Int, val endValue: Int): DiscountType()
    object NoDiscount: DiscountType()

    override fun toString(): String {
        return when(this) {
            is FlatAmount -> "Flat Amount"
            is RangeAmount -> "Range Amount"
            NoDiscount -> "Object discount type"
        }
    }
}
