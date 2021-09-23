package com.bignerdranch.android.androidprojecttms

sealed class Delivery() {
    data class DpdBy(val coast: Int) : Delivery()
    data class BoxAgentCom(val coast: Int) : Delivery()
    data class VozimBy(val coast: Int) : Delivery()

    override fun toString(): String {
        return when (this) {
            is BoxAgentCom -> "BoxAgent.com"
            is DpdBy -> "DPD.by"
            is VozimBy -> "Vozim.by"
        }
    }
}
