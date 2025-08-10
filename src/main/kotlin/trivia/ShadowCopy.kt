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