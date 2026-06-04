package com.example.libraryapp.screens.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.libraryapp.data.Book

@Composable
fun BookRow(
    book: Book,
    borrowCount: Int = 0,
    averageRating: Double = 0.0
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = book.title)
            Text(text = "Author: ${book.author}")
            Text(text = "Times borrowed/read: $borrowCount")

            if (averageRating == 0.0) {
                Text(text = "Average rating: No ratings yet")
            } else {
                Text(text = "Average rating: ${String.format("%.2f", averageRating)}")
            }
        }
    }
}