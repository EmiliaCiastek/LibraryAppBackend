package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.model.Book
import com.ciastek.librarybackend.model.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BooksController @Autowired constructor(private val bookRepository: BookRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllBooks(@RequestParam(required = false) authorId: Long?): List<Book> =
            if (authorId != null) {
                bookRepository.getAllBooksByAuthorId(authorId)
            } else {
                bookRepository.getAllBooks()
            }

    @RequestMapping(method = [RequestMethod.POST])
    fun addBook(@RequestBody book: Book): Book =
            book.apply {
                id = bookRepository.addBook(book)
            }
}
