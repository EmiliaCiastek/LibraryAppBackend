package com.ciastek.librarybackend.database

import com.ciastek.librarybackend.database.entity.Author
import org.springframework.stereotype.Repository

@Repository
class InMemoryAuthorRepository : AuthorRepository {

    private val authors by lazy {
        mutableListOf(
                Author(name = "Svetlana", lastName = "Isakova", id = 0),
                Author(name = "John Ferguson", lastName = "Smart", id = 1),
                Author(name = "Robert C.", lastName = "Martin", id = 2),
                Author(name = "Tess", lastName = "Gerritsen", id = 3),
                Author(name = "Robyn", lastName = "Harding", id = 4)
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

    override fun getAuthor(id: Long): Author? {
        return authors.find { it.id == id }
    }
}
