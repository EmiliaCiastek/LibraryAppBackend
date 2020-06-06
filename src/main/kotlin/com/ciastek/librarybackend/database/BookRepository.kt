package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Book


interface BookRepository {

    fun getAllBooks(): List<Book>

    fun addBook(book: Book): Long

    fun getAllBooksByAuthorId(authorId: Long): List<Book>

    fun findBooksByTitle(title: String): List<Book>
}