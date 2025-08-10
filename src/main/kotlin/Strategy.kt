package org.example

/**
 * This is a Strategy pattern in Kotlin.
 * It allows you to define a family of algorithms, encapsulate each one in a separate class,
 * and make them interchangeable within the context object.
 *
 * The pattern is particularly useful when you have multiple ways to perform a task and
 * want to enable the dynamic selection of the algorithm based on the application's current state or user input.
 *
 * Key advantages of the Strategy pattern include:
 * Flexibility: It allows the algorithm to be selected at runtime, enabling dynamic behavior changes.
 * Reusability: Individual algorithms are encapsulated in separate classes, making them reusable across different contexts.
 */
interface Strategy {
    fun pay(amount: Int)
}

class CreditCardStrategy(val cardNumber: String) : Strategy {
    override fun pay(amount: Int) {
        println("Paid $amount using Credit Card: $cardNumber")
    }
}

class PayPalStrategy(val email: String) : Strategy {
    override fun pay(amount: Int) {
        println("Paid $amount using PayPal: $email")
    }
}

class ShoppingCart {
    private var strategy: Strategy? = null

    fun setPaymentStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun checkout(amount: Int) {
        strategy?.pay(amount) ?: println("No payment strategy set.")
    }
}

fun main() {
    val cart = ShoppingCart()
    val creditCardStrategy = CreditCardStrategy("1234-5678-9876-5432")
    val payPalStrategy = PayPalStrategy("<EMAIL>")

    // Using Credit Card payment strategy
    cart.setPaymentStrategy(creditCardStrategy)
    cart.checkout(100)

    // Using PayPal payment strategy
    cart.setPaymentStrategy(payPalStrategy)
    cart.checkout(200)
}