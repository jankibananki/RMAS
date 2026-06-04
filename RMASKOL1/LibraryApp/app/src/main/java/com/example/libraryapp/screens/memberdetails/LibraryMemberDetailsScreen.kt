package com.example.libraryapp.screens.memberdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.libraryapp.data.Book
import com.example.libraryapp.data.LibraryMember
import com.example.libraryapp.data.ReadedBook
import java.lang.reflect.Member

@Composable
fun LibraryMemberDetailsScreen(
    member: LibraryMember?,
    books: List<Book>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if(member == null) {
        return
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .width(280.dp)
                .padding(10.dp)
        ) {
            Text(
                text = "Ime: ${member.firstName}",
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Prezime: ${member.lastName}",
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Godina upisa: ${member.yearOfRegistration}",
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        AddReadedBook(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.height(20.dp))
        RadedBooksList(member.readedBooks)
    }
}

@Composable
fun RadedBooksList(
    readedBooks: List<ReadedBook>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PROCITANE KNJIGE",
            fontSize = 25.sp
        )
        LazyColumn(

        ) {
            items(readedBooks) { book ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(200.dp)
                ) {
                    Text(
                        text = "Title: ${book.book.title}",
                        modifier = Modifier.padding(4.dp)
                    )
                    Text(
                        text = "Author: ${book.book.author}",
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AddReadedBook (
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(20.dp)
        ) {
            Text(
                text = "Dodaj procitanu knjigu",
                fontSize = 20.sp,
                modifier = Modifier.padding(4.dp)
            )
            Button(
                modifier = Modifier.width(200.dp),
                onClick = {}
            ) {
                Text("Select book")
            }
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Ocena") },
                modifier = Modifier
                    .width(200.dp)
                    .padding(bottom = 15.dp)
            )
            Button(
                modifier = Modifier.width(200.dp),
                onClick = {}
            ) {
                Text("Save")
            }
            Button(
                modifier = Modifier.width(200.dp),
                onClick = onBackClick
            ) {
                Text("Back")
            }
        }
    }

}

