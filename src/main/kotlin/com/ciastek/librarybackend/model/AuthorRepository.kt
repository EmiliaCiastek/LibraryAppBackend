package com.ciastek.librarybackend.model

interface AuthorRepository {

    fun getAllAuthors(): List<Author>

    fun addAuthor(author: Author): Long

    fun findAuthors(name: String?, lastName: String?): List<Author>
}
