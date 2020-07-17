package com.ciastek.librarybackend

import com.ciastek.librarybackend.database.entity.BookRate
import com.ciastek.librarybackend.database.entity.Author as AuthorEntity
import com.ciastek.librarybackend.model.Author
import com.ciastek.librarybackend.model.Book
import com.ciastek.librarybackend.model.DetailedAuthor
import com.ciastek.librarybackend.model.DetailedBook
import  com.ciastek.librarybackend.database.entity.Book as BookEntity


internal fun BookEntity.mapToViewModel(author: AuthorEntity?): Book {
    val authorName = if (author != null) "${author.name} ${author.lastName}" else ""

    return Book(id = id, title = title, author = authorName, authorId = authorId)
}

internal fun BookEntity.mapToDetailedViewModel(author: AuthorEntity?): DetailedBook {
    val authorName = if (author != null) "${author.name} ${author.lastName}" else ""

    return DetailedBook(id = id, title = title, author = authorName, rating = ratings.average(), coverUrl = coverUrl
            ?: "", description = description ?: "", authorId = author!!.id!!)
}

internal fun DetailedBook.mapToEntity() =
        BookEntity(id = id, title = title, authorId = authorId, ratings = emptyList(), coverUrl = coverUrl, description = description)

internal fun Author.mapToEntity() =
        AuthorEntity(id = id, name = name, lastName = lastName)

internal fun AuthorEntity?.mapToDetailedViewModel(books: List<Book>) =
        if (this != null) {
            DetailedAuthor(id, name, lastName, birthDate, deathDate, website, genres, photoUrl, description, books)
        } else {
            DetailedAuthor.empty()
        }

internal fun AuthorEntity.mapToViewModel(numberOfBooks: Int) =
        Author(id = id, name = name, lastName = lastName, numberOfBooks = numberOfBooks, photoUrl = photoUrl)

internal fun List<BookRate>.average() =
        if (isNotEmpty())
            map { it.rate }.average()
        else 0.0
