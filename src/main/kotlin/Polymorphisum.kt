package org.example

/**
 * This is an example of Polymorphism in Kotlin.
 *
 * Overriding - runtime polymorphism: Replacing a method or property from a parent class or interface in a subclass.
 *
 *
 * Overloading - compile-time polymorphism: Creating multiple methods with the `same name`
 *               but `different parameters` in the same scope.
 */
object Polymorphisum {

    open class Animal {
        open fun sound() {
            println("Animal makes a sound")
        }
    }

    class Dog : Animal() {
        override fun sound() { // Overriding the sound method - runtime polymorphism
            println("Dog barks")
        }
    }

    class Cat : Animal() {
        override fun sound() {
            println("Cat meows")
        }
    }

    // Overloading example - compile-time polymorphism
    // You can treat different subclasses as the same type (the parent), enabling flexible code.
    fun makeSound(animal: Animal) {
        animal.sound()
    }

    fun makeSound(animal: Animal, times: Int) {
        repeat(times) {
            animal.sound()
        }
    }
}

fun main() {
    // Creating instances of Dog and Cat
    val dog: Polymorphisum.Animal = Polymorphisum.Dog()
    val cat: Polymorphisum.Animal = Polymorphisum.Cat()

    // Calling the overridden sound method
    dog.sound() // Output: Dog barks
    cat.sound() // Output: Cat meows

    // Using the overloaded makeSound method
    Polymorphisum.makeSound(cat)
    Polymorphisum.makeSound(cat, 2) // Output: Cat meows (twice)
}