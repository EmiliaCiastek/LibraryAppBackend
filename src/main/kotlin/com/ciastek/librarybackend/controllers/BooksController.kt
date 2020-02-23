package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.model.Book
import com.ciastek.librarybackend.model.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BooksController @Autowired constructor(private val bookRepository: BookRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllBooks(): List<Book> {
        return bookRepository.getAllBooks()
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun addBook(@RequestBody book: Book): Book {
        bookRepository.addBook(book)

        return book
    }
}