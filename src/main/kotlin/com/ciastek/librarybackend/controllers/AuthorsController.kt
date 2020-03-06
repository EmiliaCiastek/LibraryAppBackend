package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.model.Author
import com.ciastek.librarybackend.model.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
class AuthorsController @Autowired constructor(private val authorRepository: AuthorRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllAuthors(): List<Author> =
            authorRepository.getAllAuthors()

    @RequestMapping(method = [RequestMethod.POST])
    fun addAuthor(@RequestBody author: Author): Author =
            author.apply {
                id = authorRepository.addAuthor(author)
            }
}
