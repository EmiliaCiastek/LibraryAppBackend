package com.ciastek.librarybackend.model

import org.springframework.stereotype.Repository

@Repository
class InMemoryBookRepository : BookRepository {

    private val books by lazy {
        mutableListOf(
                Book("Kotlin in Action", 0, 0),
                Book("Bdd in action", 1, 1),
                Book("Clean code", 2, 2),
                Book("Gravity", 3, 3),
                Book("Clean Coder", 2, 4)
        )
    }

    override fun getAllBooks(): List<Book> = books.toList()

    override fun addBook(book: Book): Long {
        books.add(book)

        return books.indexOf(book).toLong()
    }

    override fun getAllBooksByAuthorId(authorId: Long): List<Book> =
            books.filter { it.authorId == authorId }
                    .toList()

    override fun findBooksByTitle(title: String): List<Book> =
        books.filter {
            it.title.toLowerCase()
                    .contains(title.toLowerCase())
        }
                .toList()
}