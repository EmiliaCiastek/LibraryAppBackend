package com.ciastek.librarybackend.model

import org.springframework.stereotype.Repository

@Repository
class InMemoryBookRepository: BookRepository {

    private val books: MutableList<Book> by lazy {
        mutableListOf(
                Book("Kotlin in Action", "Svetlana Isakova"),
                Book("Bdd in action", "John Ferguson Smart"),
                Book("Clean code", "Robert C. Martin"),
                Book("Gravity", "Tess Gerritsen")
        )
    }

    override fun getAllBooks(): List<Book> = books.toList()

    override fun addBook(book: Book) {
        books.add(book)
    }
}