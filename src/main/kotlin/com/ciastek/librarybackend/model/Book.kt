package com.ciastek.librarybackend.model

data class Book (var id: Long?, val title: String, val author: String, val authorId: Long)

data class DetailedBook(val id: Long?, val title: String, val author: String, val rating: Double, val coverUrl: String, val description: String) {

    companion object {

        fun empty() = DetailedBook(-1, "", "", 0.0, "",  "")
    }
}