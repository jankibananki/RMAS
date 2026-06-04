package com.example.libraryapp.data

data class LibraryMember(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val yearOfRegistration: Int,
    var readedBooks: List<ReadedBook>
)
