package shopping.cart

import org.specs2.mutable.Specification
import Checkout._

class CheckoutTest extends Specification {
  "Shopping cart" should {
    "cost nothing when there are no items" in {
      costOf(ShoppingCart()) mustEqual 0.00
    }

    "cost 60p for 1 apple" in {
      costOf(ShoppingCart(Apple)) mustEqual 0.60
    }

    "cost £1.20 for 2 apples" in {
      costOf(ShoppingCart(Apple, Apple)) mustEqual 1.20
    }

    "cost 25p for 1 orange" in {
      costOf(ShoppingCart(Orange)) mustEqual 0.25
    }

    "cost 50p for 2 oranges" in {
      costOf(ShoppingCart(Orange, Orange)) mustEqual 0.50
    }

    "£2.05 for 3 apples and 1 orange" in {
      costOf(ShoppingCart(Apple, Apple, Orange, Apple)) mustEqual 2.05
    }
   }
}