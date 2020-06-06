package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Book
import org.springframework.stereotype.Repository

@Repository
class InMemoryBookRepository : BookRepository {

    private val books by lazy {
        mutableListOf(
                Book(title = "Kotlin in Action", authorId = 0, id = 0),
                Book(title = "Bdd in action", authorId = 1, id = 1),
                Book(title = "Clean code", authorId = 2, id = 2),
                Book(title = "Gravity", authorId = 3, id = 3),
                Book(title = "Clean Coder", authorId = 2, id = 4)
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