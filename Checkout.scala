package shopping.cart

object Checkout {
  type Discount = BigDecimal

  def costOf(shoppingCart: ShoppingCart, discounts: (ShoppingCart => Discount)*): BigDecimal = {
    val discount = discounts.foldLeft(BigDecimal(0.00)) { (discountAcc, discount) => discountAcc + discount(shoppingCart) }
    shoppingCart.items.map(_.price).sum - discount
  }
}