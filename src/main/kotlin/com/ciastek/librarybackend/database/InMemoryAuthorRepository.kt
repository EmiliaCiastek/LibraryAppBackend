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
                Author(name = "Robyn", lastName = "Harding", id = 4),
                Author(name = "John Ronald Reuel", lastName = "Tolkien", id = 5, birthDate = "03-01-1892", deathDate = "02-09-1973", website = "http://www.tolkienestate.com/", genres = "Fantasy, Fiction, Children's", photoUrl = "https://i.wpimg.pl/O/464x660/d.wpimg.pl/822554738--93831743/j-r-r-tolkien-tolkien.jpg", description = tolkienDesc)
        )
    }

    override fun getAllAuthors(): List<Author> = authors.toList().sort()

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
                .sort()
    }

    override fun getAuthor(id: Long): Author? {
        return authors.find { it.id == id }
    }

    private fun List<Author>.sort() =
            sortedWith(compareBy({ it.lastName }, { it.name }))

    private val tolkienDesc = "John Ronald Reuel Tolkien, CBE was an English writer, poet, WWI veteran, philologist, and university professor, best known as the author of the high fantasy classic works The Hobbit and The Lord of the Rings."
}
