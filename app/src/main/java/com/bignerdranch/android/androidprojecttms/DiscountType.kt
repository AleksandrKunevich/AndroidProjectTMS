package com.bignerdranch.android.androidprojecttms

enum class DiscountType() {
    FlatAmount,
    RangeAmount;

    override fun toString(): String {
        return when(this) {
            FlatAmount -> "Flat Amount"
            RangeAmount -> "Range Amount"
        }
    }
}
