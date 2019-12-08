package com.ciastek.librarybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryBackendApplication

fun main(args: Array<String>) {
	runApplication<LibraryBackendApplication>(*args)
}
