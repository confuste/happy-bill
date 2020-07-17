package com.alexfuster.happybill.model

class Payment(private val item: Item, private val itemAmount: Int = 1, private val friendList: List<Friend> = emptyList()) {



    fun addFriend(friend: Friend) {
        if (friend !in friendList) {
            friendList.toMutableList().add(friend)
        }
    }

    fun removeFriend(friend: Friend) = friendList.toMutableList().remove(friend)


    fun howMuchDoYouPay(friend: Friend): Float =
        if(friend in friendList) (item.price * itemAmount) / friendList.size else 0.0f

}