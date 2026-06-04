package com.example.libraryapp.screens.addmember

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddLibraryMemberScreen(
    modifier: Modifier = Modifier,
    onSaveClick: (String, String, Int) -> Unit,
    onBackClick: () -> Unit,
    navController: NavController
) {
    var newIme by rememberSaveable { mutableStateOf("") }
    var newPrezime by rememberSaveable { mutableStateOf("") }
    var newGodinaUpisa by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = newIme,
            onValueChange = { newIme = it },
            label = { Text("Ime") }
        )
        OutlinedTextField(
            value = newPrezime,
            onValueChange = { newPrezime = it },
            label = { Text("Prezime") }
        )
        OutlinedTextField(
            value = newGodinaUpisa,
            onValueChange = { newGodinaUpisa = it },
            label = { Text("Godina upisa") }
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedButton(
            modifier = Modifier.width(200.dp),
            onClick = {
                onSaveClick(newIme, newPrezime, newGodinaUpisa.toInt())
                navController.popBackStack()
            }
        ) {
            Text("Save")
        }
        OutlinedButton(
            modifier = Modifier.width(200.dp),
            onClick = onBackClick
        ) {
            Text("Cancel")
        }
    }
}

