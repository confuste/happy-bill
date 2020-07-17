package com.alexfuster.happybill

import com.alexfuster.happybill.model.Bill
import com.alexfuster.happybill.model.Friend
import com.alexfuster.happybill.model.Item
import com.alexfuster.happybill.model.Payment
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun whenAskForUserMoneyAmountOfItem_ShouldGetTheMoneyToPayForThisItem() {

    val item1 = Item("Cheese", 10f)

    val friend1 = Friend("Lopez")
    val friend2 = Friend("Fernando")
    val friend3 = Friend("Michela")
    val friend4 = Friend("Alex")

    val payment = Payment(item1, 1, listOf(friend1, friend2, friend3, friend4))

    assertEquals(2.5f, payment.howMuchDoYouPay(friend1))
  }

  @Test
  fun whenAskForTotalAmountOfUSer_ShouldGetTotalMoneyToPay() {

    val item1 = Item("Cheese", 2.5f)
    val item2 = Item("Pizza", 5f)
    val item3 = Item("Wine", 7f)
    val item4 = Item("Ice Cream", 2f)

    val friend1 = Friend("Lopez")
    val friend2 = Friend("Fernando")
    val friend3 = Friend("Michela")
    val friend4 = Friend("Alex")

    val payment1 = Payment(item1, 1, listOf(friend1, friend2, friend3, friend4))
    val payment2 = Payment(item2, 3,  listOf(friend1, friend2))
    val payment3 = Payment(item3, 1, listOf(friend1, friend4))
    val payment4 = Payment(item4, 6,  listOf(friend1, friend3, friend4))

    val bill = Bill(listOf(payment1, payment2, payment3, payment4))

    assertEquals(15.625f, bill.totalMoney(friend1))
  }
}