package com.ciastek.librarybackend.database.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "books")
data class Book(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long? = 0L,
                val title: String = "",
                val authorId: Long = 0L)