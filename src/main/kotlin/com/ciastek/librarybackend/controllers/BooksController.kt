package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.database.AuthorRepository
import com.ciastek.librarybackend.database.BookRepository
import com.ciastek.librarybackend.mapToDetailedViewModel
import com.ciastek.librarybackend.mapToEntity
import com.ciastek.librarybackend.mapToViewModel
import com.ciastek.librarybackend.model.Book
import com.ciastek.librarybackend.model.DetailedBook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BooksController @Autowired constructor(private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllBooks(@RequestParam(required = false) authorId: Long?): List<Book> =
            if (authorId != null) {
                bookRepository.getAllByAuthorId(authorId)
            } else {
                bookRepository.getAll()
            }
                    .map {
                        it.mapToViewModel(authorRepository.getAuthorById(it.authorId))
                    }

    @RequestMapping("/{id}", method = [RequestMethod.GET])
    fun getBook(@PathVariable("id") id: Long): DetailedBook {
        val book = bookRepository.getById(id)
        return book.mapToDetailedViewModel(authorRepository.getAuthorById(book.authorId))
    }


    @RequestMapping(method = [RequestMethod.POST])
    fun addBook(@RequestBody book: Book): Book =
            book.apply {
                id = bookRepository.save(book.mapToEntity())
            }

}
