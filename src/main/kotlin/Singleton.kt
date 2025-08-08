package org.example

/**
 * This is a singleton object in Kotlin.
 * It can be used to hold global state or utility functions.
 *
 * The Singleton pattern is crucial because it helps you manage shared resources more efficiently.
 * For example, think of scenarios like logging, configuration settings,
 * or database connections — these are areas where you typically need only one instance.
 *
 * It provides thread safety and lazy loading by default:
 * Lazy loading: This means that the Singleton instance is not created until it is first needed,
 * which can save resources and increase efficiency.
 *
 * Thread safety: Ensures that even in multithreaded environments, there is no risk of creating multiple instances of
 * the Singleton.
 */
object Singleton {

    init {
        // Notice that the log message "Singleton instance created." is only displayed once,
        println("Singleton instance created.")
    }

    fun showMessage() {
        println("Hello from Singleton!")
    }
}

fun main() {
    // Accessing the singleton object and calling its method
    Singleton.showMessage()

    val singleton1 = Singleton
    val singleton2 = Singleton

    // Demonstrating that both references point to the same instance
    // In Kotlin, === checks for referential equality, meaning it tests whether two references point to
    // the exact same object instance in memory.
    if (singleton1 === singleton2) {
        println("Both references point to the same Singleton instance.")
    } else {
        println("Singleton instances are different, which should not happen.")
    }
}