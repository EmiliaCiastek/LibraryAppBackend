package com.ciastek.librarybackend.controllers

import com.ciastek.librarybackend.model.Author
import com.ciastek.librarybackend.model.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authors")
class AuthorsController @Autowired constructor(private val authorRepository: AuthorRepository) {

    @RequestMapping(method = [RequestMethod.GET])
    fun getAllAuthors(@RequestParam(required = false) name: String?,
                      @RequestParam(required = false) lastName: String?): List<Author> =
        if(name == null && lastName == null) {
            authorRepository.getAllAuthors()
        } else {
            authorRepository.findAuthors(name, lastName)
        }


    @RequestMapping(method = [RequestMethod.POST])
    fun addAuthor(@RequestBody author: Author): Author =
            author.apply {
                id = authorRepository.addAuthor(author)
            }
}
