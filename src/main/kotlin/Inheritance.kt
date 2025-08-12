package org.example

/**
 * This is an example of Inheritance in Kotlin.
 * Kotlin doesn’t support multiple inheritance for classes (only interfaces),
 * so you can’t inherit from two different base classes.
 */
object Inheritance {

    open class Animal {
        // Disadvantage: If you change the base class, you may need to change all subclasses.
        open fun eat() {
            println("Eating...")
        }
    }

    class Dog : Animal()

    class Cat : Animal() {
        // You can add new behavior in subclasses without changing the base class.
        fun scratch() {
            println("Scratching...")
        }
    }

    //You can treat different subclasses as the same type (the parent), enabling flexible code.
    fun doingSomething(animal: Animal) {
        animal.eat() // Calls the eat method from the Animal class
    }
}

fun main() {
    val dog: Inheritance.Animal = Inheritance.Dog()
    dog.eat() // Output:Eating...
    // Note: The Dog class does not override the sound method, so it uses the parent class implementation.
    // If you want to override the sound method in Dog, you can do so like this

    val cat: Inheritance.Animal = Inheritance.Cat()
    Inheritance.doingSomething(dog)
    Inheritance.doingSomething(cat)

    if (cat is Inheritance.Cat) {
        cat.scratch() // Output: Scratching...
    }
}