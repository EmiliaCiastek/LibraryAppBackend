package com.ciastek.librarybackend.database.entity

data class Author(val id: Long?,
                  val name: String,
                  val lastName: String,
                  val birthDate: String = "",
                  val deathDate: String = "",
                  val website: String = "",
                  val genres: String = "",
                  val photoUrl: String = "",
                  val description: String = "")
