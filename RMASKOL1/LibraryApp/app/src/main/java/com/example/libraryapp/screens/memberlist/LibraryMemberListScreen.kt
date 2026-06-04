package com.example.libraryapp.screens.memberlist

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.libraryapp.data.LibraryMember

@Composable
fun LibraryMemberListScreen(
    members: List<LibraryMember>,
    onAddMemberClick: () -> Unit,
    onBooksClick: () -> Unit,
    onMemberClick: (LibraryMember) -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Library members",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (members.isEmpty()) {
                Text("No members added.")
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(members) { member ->
                        LibraryMemberRow(
                            member = member,
                            onMemberClick = onMemberClick
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onAddMemberClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add member")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onBooksClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Books")
            }
        }
    }
}