package com.bignerdranch.android.androidprojecttms

data class Discount(
    var title: String,
    var description: String,
    var discountAmount: Int,
    var imageUrl: String,
    var siteUrl: String,
    var discountType: DiscountType
) {
    fun getMyTitle() = title.uppercase()
    fun setMyDescription(value: String) {
        description = if (value.length <= 100) {
            value
        } else {
            value.substring(0, 100)
        }
    }
}