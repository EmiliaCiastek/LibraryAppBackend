package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: JpaRepository<Author, Long> {

    @Query("FROM authors ORDER BY last_name, name")
    fun getAllAuthors(): List<Author>

    fun save(author: Author): Long

    fun getAuthorById(id: Long): Author?
}
