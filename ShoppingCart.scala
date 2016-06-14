package shopping.cart

case class ShoppingCart(items: Item*)

sealed trait Item {
  val price: BigDecimal
}

case object Apple extends Item {
  val price = BigDecimal(0.60)
}

case object Orange extends Item {
  val price = BigDecimal(0.25)
}
}