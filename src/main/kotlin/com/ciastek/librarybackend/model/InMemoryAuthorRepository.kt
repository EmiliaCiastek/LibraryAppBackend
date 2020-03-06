package com.ciastek.librarybackend.model

import org.springframework.stereotype.Repository

@Repository
class InMemoryAuthorRepository: AuthorRepository {

    val authors by lazy {
                mutableListOf(
                        Author("Svetlana", "Isakova"),
                        Author("John Ferguson", "Smart"),
                        Author("Robert C.", "Martin"),
                        Author("Tess", "Gerritsen")
        )
    }

    override fun getAllAuthors(): List<Author> = authors.toList()

    override fun addAuthor(author: Author) {
        authors.add(author)
    }
}
