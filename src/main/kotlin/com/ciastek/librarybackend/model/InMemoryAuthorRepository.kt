package com.ciastek.librarybackend.model

import org.springframework.stereotype.Repository

@Repository
class InMemoryAuthorRepository : AuthorRepository {

    val authors by lazy {
        mutableListOf(
                Author("Svetlana", "Isakova", 0),
                Author("John Ferguson", "Smart", 1),
                Author("Robert C.", "Martin", 2),
                Author("Tess", "Gerritsen", 3)
        )
    }

    override fun getAllAuthors(): List<Author> = authors.toList()

    override fun addAuthor(author: Author): Long {
        authors.add(author)

        return authors.indexOf(author).toLong()
    }
}
