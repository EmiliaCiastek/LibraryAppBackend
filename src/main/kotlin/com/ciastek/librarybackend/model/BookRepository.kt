package com.ciastek.librarybackend.model

interface BookRepository {

    fun getAllBooks(): List<Book>

    fun addBook(book: Book): Long

    fun getAllBooksByAuthorId(authorId: Long): List<Book>

    fun findBooksByTitle(title: String): List<Book>
}