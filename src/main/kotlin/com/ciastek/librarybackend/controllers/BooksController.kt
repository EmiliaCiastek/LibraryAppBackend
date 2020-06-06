package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.database.AuthorRepository
import com.ciastek.librarybackend.model.Book
import  com.ciastek.librarybackend.database.entity.Book as BookEntity
import com.ciastek.librarybackend.database.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BooksController @Autowired constructor(private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllBooks(@RequestParam(required = false) authorId: Long?): List<Book> =
            if (authorId != null) {
                bookRepository.getAllBooksByAuthorId(authorId)
            } else {
                bookRepository.getAllBooks()
            }
                    .map {
                       it.mapToViewModel()
                    }

    @RequestMapping(method = [RequestMethod.POST])
    fun addBook(@RequestBody book: Book): Book =
            book.apply {
                id = bookRepository.addBook(book.mapToEntity())
            }

    @RequestMapping("/{title}", method = [RequestMethod.GET])
    fun getBooksByTitle(@PathVariable("title") title: String): List<Book> =
            bookRepository.findBooksByTitle(title)
                    .map {
                        it.mapToViewModel()
                    }


    private fun BookEntity.mapToViewModel(): Book {
        val author = authorRepository.getAuthor(authorId)
        val authorName = if (author != null) "${author.name} ${author.lastName}" else ""

        return Book(id = id, title = title, author = authorName, authorId = authorId)
    }

    private fun Book.mapToEntity() =
            com.ciastek.librarybackend.database.entity.Book(id = id, title = title, authorId = authorId)
}
