package com.example.libraryapp.screens.books

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.libraryapp.data.Book
import com.example.libraryapp.data.ReadedBook

@Composable
fun BooksScreen(
    books: List<Book>,
    onBackClick: () -> Unit,
    onAddBookClick: (String, String) -> Unit,
    avargeRating: (Book) -> Double,
    borrowCount: (Book) -> Int
) {


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Books",
            style = MaterialTheme.typography.headlineMedium
        )

        //TODO: Add UI to add book
        AddBook(
            modifier = Modifier.fillMaxWidth(),
            onAddBookClick = { newNaslov, newAuthor ->
                onAddBookClick(newNaslov, newAuthor) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Library books",
            style = MaterialTheme.typography.titleMedium
        )

        if (books.isEmpty()) {
            Text("No books added.")
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(books) { book ->
                    BookRow(
                        book = book,
                        averageRating = avargeRating(book),
                        borrowCount = borrowCount(book)
                    )
                }
            }
        }

        OutlinedButton(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
fun AddBook(
    modifier: Modifier = Modifier,
    onAddBookClick: (String, String) -> Unit,
) {
    var newNaslov by rememberSaveable { mutableStateOf("") }
    var newAutor by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = newNaslov,
            onValueChange = { newNaslov = it},
            label = { Text("Naslov") },
            modifier = modifier
        )
        OutlinedTextField(
            value = newAutor,
            onValueChange = { newAutor = it},
            label = { Text("Autor") },
            modifier = modifier
        )
        OutlinedButton(
            onClick = { onAddBookClick(newNaslov, newAutor) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add BOOK")
        }
    }
}