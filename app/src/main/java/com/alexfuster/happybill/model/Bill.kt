package com.alexfuster.happybill.model

class Bill(private val paymentList: List<Payment> = emptyList()) {


    fun addPayment(payment: Payment) {
        paymentList.toMutableList().add(payment)
    }

    fun removePayment(payment: Payment) {
        paymentList.toMutableList().remove(payment)
    }

    fun totalMoney(friend: Friend): Float =
        paymentList.map { it.howMuchDoYouPay(friend) }.sum()

}

