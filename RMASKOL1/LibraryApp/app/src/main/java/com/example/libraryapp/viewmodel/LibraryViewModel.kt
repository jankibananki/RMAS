package com.example.libraryapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.libraryapp.data.Book
import com.example.libraryapp.data.LibraryMember
import com.example.libraryapp.data.ReadedBook
import java.lang.reflect.Member

class LibraryViewModel : ViewModel() {

    var members = mutableStateOf(
        listOf(
            LibraryMember(
                id = 1,
                firstName = "Marko",
                lastName = "Markovic",
                yearOfRegistration = 2022,
                readedBooks = listOf(
                    ReadedBook(
                        book = Book(1, "Na Drini cuprija", "Ivo Andric"),
                        ocena = 9
                    ),
                    ReadedBook(
                        book = Book(2, "Prokleta avlija", "Ivo Andric"),
                        ocena = 5
                    )
                )
            ),
            LibraryMember(
                id = 2,
                firstName = "Ana",
                lastName = "Jovanovic",
                yearOfRegistration = 2023,
                readedBooks = listOf(
                    ReadedBook(
                        book = Book(1, "Na Drini cuprija", "Ivo Andric"),
                        ocena = 8
                    ),
                )
            )
        )
    )
        private set

    var books = mutableStateOf(
        listOf(
            Book(
                id = 1,
                title = "Na Drini cuprija",
                author = "Ivo Andric"
            ),
            Book(
                id = 2,
                title = "Prokleta avlija",
                author = "Ivo Andric"
            ),
            Book(
                id = 3,
                title = "Necista krv",
                author = "Bora Stankovic"
            )
        )
    )
        private set

    var selectedMember = mutableStateOf<LibraryMember?>(null)
        private set

    private var nextMemberId = 3
    private var nextBookId = 4

    fun addMember(
        firstName: String,
        lastName: String,
        yearOfRegistration: Int
    ) {
        val newMember = LibraryMember(
            id = nextMemberId,
            firstName = firstName,
            lastName = lastName,
            yearOfRegistration = yearOfRegistration,
            readedBooks = emptyList()
        )

        nextMemberId++

        members.value = members.value + newMember
    }

    fun selectMember(member: LibraryMember) {
        selectedMember.value = member
    }

    fun addBook(
        title: String,
        author: String
    ) {
        val newBook = Book(
            id = nextBookId,
            title = title,
            author = author
        )

        nextBookId++

        books.value = books.value + newBook
    }


    //Ovo je funkcija ali ne znam kako da napravim dropBox pa je zato nisam implementirao
    fun addBookToAMember(
        book: Book,
        ocena: Int,
    ) {
        val newReadedBook = ReadedBook(
            book = book,
            ocena = ocena
        )

        selectedMember.value?.readedBooks += newReadedBook
    }


    fun avargeRating(
        book: Book
    ): Double {
        var brKnjiga: Double = 0.0
        var zbirOcena: Double = 0.0

        for(mem in members.value)
        {
            for(bk in mem.readedBooks)
            {
                if(book.id == bk.book.id)
                {
                    brKnjiga++
                    zbirOcena += bk.ocena
                }
            }
        }

        return zbirOcena / brKnjiga
    }

    fun borrowCount(
        book: Book
    ): Int {
        var brKnjiga: Int = 0
        for(mem in members.value)
        {
            for(bk in mem.readedBooks)
            {
                if(book.id == bk.book.id)
                {
                    brKnjiga++
                }
            }
        }
        return brKnjiga
    }


}