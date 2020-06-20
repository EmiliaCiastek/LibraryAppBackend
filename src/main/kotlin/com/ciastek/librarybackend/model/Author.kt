package com.ciastek.librarybackend.model

import javax.persistence.Column

data class Author(var id: Long?, val name: String, val lastName: String, val numberOfBooks: Int, val photoUrl: String)

data class DetailedAuthor(val id: Long?,
                          val name: String,
                          val lastName: String,
                          val birthDate: String,
                          val deathDate: String,
                          val website: String,
                          val genres: String,
                          val photoUrl: String,
                          @Column(columnDefinition="TEXT") val description: String,
                          val books: List<Book>) {

    companion object {

        fun empty() = DetailedAuthor(-1, "", "", "", "", "", "", "", "", emptyList())
    }
}