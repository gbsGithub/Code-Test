Shopping Cart - BDD example of Scala
====================================

Application built with the following (main) technologies:

- Scala 2.11.2

- SBT 0.13.5

- Specs2 2.4.2

Introduction
------------

Satisfy the given requirements:

Step 1: Shopping cart
- You are building a checkout system for a shop which only sells apples and oranges.  
- Apples cost 60p and oranges cost 25p.
- Build a checkout system which takes a list of items scanned at the till and outputs the total cost
- For example: [ Apple, Apple, Orange, Apple ] => £2.05
- Make reasonable assumptions about the inputs to your solution; for example, many candidates take a list of strings as input
 
Step 2: Simple offers
- The shop decides to introduce two new offers:
 - buy one, get one free on Apples
 - 3 for the price of 2 on Oranges

Setup
-----

To get you going with this application, just follow along:

In a directory where you wish to clone this project from git:
> $ git clone https://github.com/davidainslie/shopping-cart.git

Go into the application's new project directory (with the "cd" shown) and complete the following:
> $ cd shopping-cart

> $ activator

> [shopping-cart] $ update-classifiers

> [shopping-cart] $ gen-idea sbt-classifiers

> [shopping-cart] $ test

Hopefully all (unit) "specs" will pass and you can now open up IntelliJ and start going through "The Code" as explained below.

The Code
--------

**Step 1: Shopping cart (tagged as v1.0.0 Step 1)**

CheckoutSpec is the starting point, that has examples covering the stated behaviour.

The ShoppingCart is a simple case (domain) class and items such as Apples, Oranges are represented as case objects. Why? I did first code these as case classes with "price" declared in an items's constructor. This is fine for different types of say apples with varying prices, but the requirements/behaviour only state "apple" and "orange", so I wanted a single price per item. And why not choose an Enumeration? Habit I guess, related to using Akka. And why case objects and not just objects? That comes down to more of a preference, but if these objects did not need serialization, and performance was an issue, then objects would be preferred.

A final note regarding money. As can be seen, from the implementation, Checkout, and domain objects, that I have immediately chosen BigDecimal. This is far better than using Double, but in a real application, one should chose a 3rd party such as Joda Time, or even better, Squants.

**Step 2: Simple offers (tagged as v1.0.1 Step 2)**

CheckoutOffersSpec is the starting point, that has examples covering the stated behaviour.

Originally I believe I focused too much on the stated behaviour of an "apples offer" and "oranges offer". The updated implementation in Checkout used "groupBy" to group items and so calculate offers only according to "item type". Thinking more about the behaviour, I decided to also focus on simply an "offer" (e.g. an offer could mix item types). And so the offers (or even rules) are kept very much independent by being "functional" i.e. given a shopping cart, give a discount according to "an offer" - the offers are not embedded in Checkout allowing for easy addition/changes of offers and also testability i.e. an offer can be tested "standalone" such as the examples for "Apple discounts". Going this way, and adding more examples, I realised that this chosen API allows discounts to be repeated and so exceed an item's price thereby giving a negative cost. However, this implementation can be altered to disallow that - indeed extra rules would have to be added to Checkout, maybe certain customers would be allowed say a double discount. This is just behaviour, and ultimately implementation details which are not part of the given requirements.