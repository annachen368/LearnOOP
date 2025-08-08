package org.example

/**
 * This is a singleton object in Kotlin.
 * It can be used to hold global state or utility functions.
 *
 * The Singleton pattern is crucial because it helps you manage shared resources more efficiently.
 * For example, think of scenarios like logging, configuration settings,
 * or database connections — these are areas where you typically need only one instance.
 */
object Singleton {
    fun showMessage() {
        println("Hello from Singleton!")
    }
}

fun main() {
    // Accessing the singleton object and calling its method
    Singleton.showMessage()
}