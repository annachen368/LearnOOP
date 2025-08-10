package org.example.trivia

/**
 * This is an example of a Deep Copy in Kotlin.
 * It creates a new instance of the object with its own data.
 * Changes to the deep copy do not affect the original object.
 * Slower than shadow copy, as it involves copying all data.
 */
class DeepCopy {
    data class Person(var name: String)

    val original = Person("Anna")
    val deepCopy = original.copy()

    val originalList = listOf(original)
    val deepCopyList = originalList.map { it.copy() } // Creates a new list with deep copies of the Person objects
}

fun main() {
    val deepCopyExample = DeepCopy()
    println("Original: ${deepCopyExample.original}")
    println("Deep Copy: ${deepCopyExample.deepCopy}")

    // Output: true -> This checks if the contents are equal, not the references.
    println("${deepCopyExample.original == deepCopyExample.deepCopy}")

    // Output: false -> This checks if they are the same instance (which they are not).
    println("${deepCopyExample.original === deepCopyExample.deepCopy}")

    // Modifying the deep copy does not affect the original
    deepCopyExample.deepCopy.name = "Bob"
    println("After modification:")
    println("Original: ${deepCopyExample.original}")
    println("Deep Copy: ${deepCopyExample.deepCopy}")
    // This shows that the deep copy is a separate instance.
    // Original: Person(name=Anna)
    // Deep Copy: Person(name=Bob)

    println("===========================")

    println("Original List: ${deepCopyExample.originalList}")
    println("Deep Copy List: ${deepCopyExample.deepCopyList}")
    // Modifying the deep copy list does not affect the original list
    deepCopyExample.deepCopyList[0].name = "Charlie"
    println("After modifying deep copy list:")
    println("Original List: ${deepCopyExample.originalList}")
    println("Deep Copy List: ${deepCopyExample.deepCopyList}")
    // This shows that the deep copy list contains separate instances of the Person object.
    // Original List: [Person(name=Anna)]
    // Deep Copy List: [Person(name=Charlie)]
}