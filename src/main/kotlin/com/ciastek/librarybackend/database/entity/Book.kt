package com.ciastek.librarybackend.database.entity

import javax.persistence.*

@Entity(name = "books")
data class Book(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long? = -1L,
                val title: String = "",
                val authorId: Long = 0L,
                val rating: Double? = null,
                val coverUrl: String? = "",
                @Column(columnDefinition="TEXT") val description: String? = "")