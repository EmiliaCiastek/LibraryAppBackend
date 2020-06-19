package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.model.Author
import com.ciastek.librarybackend.database.AuthorRepository
import com.ciastek.librarybackend.database.BookRepository
import com.ciastek.librarybackend.mapToDetailedViewModel
import com.ciastek.librarybackend.mapToEntity
import com.ciastek.librarybackend.mapToViewModel
import com.ciastek.librarybackend.model.DetailedAuthor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorsController @Autowired constructor(private val authorRepository: AuthorRepository, private val bookRepository: BookRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllAuthors(): List<Author> =
                authorRepository.getAllAuthors()
                        .map { it.mapToViewModel(bookRepository.getAllByAuthorId(it.id!!).size) }


    @RequestMapping(method = [RequestMethod.POST])
    fun addAuthor(@RequestBody author: Author): Author =
            author.apply {
                id = authorRepository.save(author.mapToEntity())
            }

    @RequestMapping( "/{id}", method = [RequestMethod.GET])
    fun getAuthor(@PathVariable("id") id: Long): DetailedAuthor {
        val author = authorRepository.getAuthorById(id)

        val books = bookRepository.getAllByAuthorId(id)
                .map { it.mapToViewModel(author) }

        return author.mapToDetailedViewModel(books)
    }
}
