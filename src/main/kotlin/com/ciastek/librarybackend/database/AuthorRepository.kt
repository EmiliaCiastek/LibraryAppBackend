package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Author

interface AuthorRepository {

    fun getAllAuthors(): List<Author>

    fun addAuthor(author: Author): Long

    fun findAuthors(name: String?, lastName: String?): List<Author>

    fun getAuthor(id: Long): Author?
}
