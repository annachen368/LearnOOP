package org.example.trivia

/**
 * This is an example of Equality in Kotlin.
 * It demonstrates the difference between structural equality (==) and referential equality (===).
 * Structural equality checks if the contents are equal,
 * while referential equality checks if both references point to the same object in memory.
 *
 * | Operator | Checks           | Uses           | Null-safe |
 * | -------- | ---------------- | -------------- | --------- |
 * | `==`     | Content equality | `.equals()`    |  Yes     |
 * | `===`    | Same reference   | memory address |  Yes     |
 *
 *
 * In Java, == compares references, .equals() compares values.
 * In Kotlin, == compares values (null-safe), and === compares references.
 */
class Equality {
    data class Person(val name: String)

    fun equality() {
        val person1 = Person("Alice")
        val person2 = Person("Alice")
        var person3 = person1

        // Structural equality checks if the contents are equal using `equals()`
        // Referential equality checks if both references point to the same object in memory
        println("Structural equality ==: ${person1 == person2}") // true
        println("Referential equality ===: ${person1 === person2}") // false
        println("Referential equality ===: ${person1 === person3}") // true
    }
}

fun main() {
    val equalityExample = Equality()
    // This is a placeholder for any functionality you might want to implement in the Equality class.
    println("Equality example initialized: $equalityExample")
    equalityExample.equality()
}

/**
 * In Java
 * == → reference equality (same as Kotlin’s ===) except for primitives.
 *
 * .equals() → value/content equality (can be overridden).
 *
 * This means in Java:
 * String a = new String("hi");
 * String b = new String("hi");
 *
 * System.out.println(a == b);      // false (different objects)
 * System.out.println(a.equals(b)); // true (same content)
 *
 *
 * In Kotlin
 * == is NOT Java’s == — Kotlin rewires it to call .equals() under the hood.
 *
 * === in Kotlin is Java’s == for objects.
 *
 * Kotlin equivalent:
 * val a = String("hi".toCharArray())
 * val b = String("hi".toCharArray())
 *
 * println(a == b)   // true  → calls a?.equals(b)
 * println(a === b)  // false → different objects
 *
 */