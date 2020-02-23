package com.ciastek.librarybackend.model

interface BookRepository {

    fun getAllBooks(): List<Book>

    fun addBook(book: Book)
}