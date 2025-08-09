package org.example

/**
 * This is a Factory Method pattern in Kotlin.
 * It is used to create objects without specifying the exact class of object that will be created.
 *
 * The factory class encapsulates the logic for creating various types of documents
 * without exposing the creation logic to the client.
 * This ensures that the client code doesn't need to know the details of how the documents are created.
 * Instead, it simply calls the factory method and receives the appropriate document instance.
 *
 * This pattern offers several key advantages:
 *
 * It `encapsulates` the object creation process, making the code more maintainable.
 * It `decouples` client code from specific classes it needs to instantiate, enhancing flexibility.
 * By adhering to the `Single Responsibility Principle`, it ensures factory classes focus solely on creating objects, promoting cleaner design.
 * It enhances `reusability`, allowing for the introduction of new object types without modifying existing code.
 * It allows for `runtime decisions` on class instantiation, enhancing adaptability.
 */
class FactoryMethod {
    /**
     * This is an enum class that defines the types of documents that can be created.
     * It helps in categorizing the different document types that the factory can produce.
     * You can easily extend this enum to include additional document types in the future,
     * making the system flexible and scalable.
     */
    enum class DocumentType {
        PDF, WORD
    }

    /**
     * the companion object allows you to call its methods using the class name directly,
     * without creating an instance of the class. This is similar to static methods in Java.
     */
    companion object {
        fun getDocument(documentType: DocumentType): Document {
            return when (documentType) {
                DocumentType.PDF -> PDFDocument()
                DocumentType.WORD -> WordDocument()
            }
        }
    }
}

/**
 * This is an interface for creating documents.
 * It defines a method to create a document, which will be implemented by concrete factories.
 */
interface Document {
    fun createDocument(): String
}

class PDFDocument : Document {
    override fun createDocument(): String {
        return "PDF Document Created"
    }
}

class WordDocument : Document {
    override fun createDocument(): String {
        return "Word Document Created"
    }
}

fun main() {
    // Using the Factory Method to create documents
    val pdfDocument = FactoryMethod.getDocument(FactoryMethod.DocumentType.PDF)
    println(pdfDocument.createDocument()) // Output: PDF Document Created

    val wordDocument = FactoryMethod.getDocument(FactoryMethod.DocumentType.WORD)
    println(wordDocument.createDocument()) // Output: Word Document Created
}