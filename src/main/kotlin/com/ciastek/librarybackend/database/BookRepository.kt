package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long> {

    @Query("FROM books ORDER BY title")
    fun getAll(): List<Book>

    fun getById(id: Long): Book

    fun save(book: Book): Book

    fun getAllByAuthorId(authorId: Long): List<Book>

    fun getAllByTitleContains(title: String): List<Book>
}