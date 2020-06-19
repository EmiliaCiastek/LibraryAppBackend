package com.ciastek.librarybackend.database.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "authors")
class Author(@Id @GeneratedValue(strategy = GenerationType.AUTO)
             val id: Long? = 0L,
             val name: String = "",
             val lastName: String= "",
             val birthDate: String = "",
             val deathDate: String = "",
             val website: String = "",
             val genres: String = "",
             val photoUrl: String = "",
             val description: String = "")
