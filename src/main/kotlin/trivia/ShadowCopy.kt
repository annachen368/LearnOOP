package org.example.trivia

/**
 * This is an example of a Shadow Copy in Kotlin.
 * It makes a new container (object, list, map, etc.) but references the same inner objects.
 * Changes to nested/mutable elements affect `both` copies.
 * Fast, because it just copies references, not the actual data.
 */
class ShadowCopy {

    data class Person(var name: String)

    val original = listOf(Person("Anna"))
    val shadowCopy = original.toList()

    fun printNames() {
        shadowCopy[0].name = "Bob"
        println("Original: ${original[0]}")
        println("Shadow Copy: ${shadowCopy[0]}")

        // Output: true -> This checks if the contents are equal, not the references.
        println("${original == shadowCopy}")

        // Output: false -> This checks if they are the same instance (which they are not).
        println("${original === shadowCopy}")

        // Output: true -> This checks if they are the same instance (which they are).
        println("${original[0] === shadowCopy[0]}")
    }
}

fun main() {
    val shadowCopyExample = ShadowCopy()
    shadowCopyExample.printNames()
    /*
    * Original: Person(name=Bob)
    * Shadow Copy: Person(name=Bob)
    *
    * This shows that both the original and shadow copy reference the same mutable object.
    */
}