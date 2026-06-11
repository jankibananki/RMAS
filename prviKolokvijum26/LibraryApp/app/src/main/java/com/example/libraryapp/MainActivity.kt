package com.example.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.libraryapp.navigation.LibraryNavHost
import com.example.libraryapp.ui.theme.LibraryAppTheme
import com.example.libraryapp.viewmodel.LibraryViewModel

class   MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LibraryAppTheme {
                val libraryViewModel: LibraryViewModel = viewModel()

                LibraryNavHost(
                    libraryViewModel = libraryViewModel
                )
            }
        }
    }
}
