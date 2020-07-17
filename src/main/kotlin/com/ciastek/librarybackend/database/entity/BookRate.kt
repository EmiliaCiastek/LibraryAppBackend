package com.ciastek.librarybackend.database.entity

import javax.persistence.*

@Entity(name = "book_rate")
data class BookRate(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                    val id: Long? = -1L,
                    val rate: Double = 0.0,
                    @ManyToOne(fetch = FetchType.EAGER)
                    @JoinColumn(name = "book_id")
                    val book: Book? = null)