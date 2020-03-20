package com.ciastek.librarybackend.model

import org.springframework.stereotype.Repository

@Repository
class InMemoryAuthorRepository : AuthorRepository {

    val authors by lazy {
        mutableListOf(
                Author("Svetlana", "Isakova", 0),
                Author("John Ferguson", "Smart", 1),
                Author("Robert C.", "Martin", 2),
                Author("Tess", "Gerritsen", 3),
                Author("Robyn", "Harding", 4)
        )
    }

    override fun getAllAuthors(): List<Author> = authors.toList()

    override fun addAuthor(author: Author): Long {
        authors.add(author)

        return authors.indexOf(author).toLong()
    }

    override fun findAuthors(name: String?, lastName: String?): List<Author> {
        return authors
                .filter { author ->
                    if (name != null) {
                        author.name.toLowerCase().contains(name.toLowerCase())
                    } else {
                        true
                    }
                }
                .filter { author ->
                    if (lastName != null) {
                        author.lastName.toLowerCase().contains(lastName.toLowerCase())
                    } else {
                        true
                    }
                }
    }
}
