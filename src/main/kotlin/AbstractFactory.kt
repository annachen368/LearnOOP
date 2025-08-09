package org.example

/**
 * This is an abstract factory class in Kotlin.
 * It provides an interface for creating families of related or dependent objects
 * without specifying their concrete classes.
 *
 * The advantages include:
 *
 * Separation of Concerns: Reduces the dependency between the client and the concrete classes, promoting loose coupling.
 * Scalability: Allows extending the families of related products easily without modifying existing code.
 * Consistency: Ensures that products created in a family are compatible and consistent with each other.
 * Code Reusability: Promotes the reuse of code by defining families of objects in one place.
 */
interface AbstractFactory {
    fun createDocument(): Document
}

/**
 * The concrete factories, like WordDocumentFactory and ExcelDocumentFactory,
 * implement the DocumentAbstractFactory interface and
 * provide the implementation for the createDocument method,
 * returning respective concrete document objects.
 */
class PDFFactory : AbstractFactory {
    override fun createDocument(): Document {
        return PDFDocument()
    }
}

class WordFactory : AbstractFactory {
    override fun createDocument(): Document {
        return WordDocument()
    }
}

/**
 * This is for another way to use the factory pattern.
 * It provides a static method to create a document using the provided factory.
 */
object DocumentFactory {
    fun createDocument(factory: AbstractFactory): Document {
        return factory.createDocument()
    }
}

fun main() {
    // Example usage of the abstract factory pattern
    val pdfFactory: AbstractFactory = PDFFactory()
    val pdfDocument = pdfFactory.createDocument()
    println(pdfDocument.createDocument()) // Output: PDF Document Created

    val wordFactory: AbstractFactory = WordFactory()
    val wordDocument = wordFactory.createDocument()
    println(wordDocument.createDocument()) // Output: Word Document Created

    // Another way to use the factory
    val pdfDocument2 = DocumentFactory.createDocument(PDFFactory())
    println(pdfDocument2.createDocument()) // Output: PDF Document Created
}