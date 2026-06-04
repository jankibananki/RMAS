package com.example.libraryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.screens.addmember.AddLibraryMemberScreen
import com.example.libraryapp.screens.books.BooksScreen
import com.example.libraryapp.screens.memberdetails.LibraryMemberDetailsScreen
import com.example.libraryapp.screens.memberlist.LibraryMemberListScreen
import com.example.libraryapp.viewmodel.LibraryViewModel

@Composable
fun LibraryNavHost(
    libraryViewModel: LibraryViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MEMBER_LIST
    ) {
        composable(Routes.MEMBER_LIST) {
            LibraryMemberListScreen(
                members = libraryViewModel.members.value,
                onAddMemberClick = {
                    navController.navigate(Routes.ADD_MEMBER)
                },
                onBooksClick = {
                    navController.navigate(Routes.BOOKS)
                },
                onMemberClick = { member ->
                    libraryViewModel.selectMember(member)
                    navController.navigate(Routes.MEMBER_DETAILS)
                }
            )
        }

        composable(Routes.BOOKS) {
            BooksScreen(
                books = libraryViewModel.books.value,
                onBackClick = {
                    navController.popBackStack()
                },
                onAddBookClick = { newNaslov, newAutor ->
                    libraryViewModel.addBook(newNaslov, newAutor)
                },
                avargeRating = { book ->
                    libraryViewModel.avargeRating(book)
                },
                borrowCount = { book ->
                    libraryViewModel.borrowCount(book)
                }

            )
        }

        composable(Routes.ADD_MEMBER) {
            AddLibraryMemberScreen(
                onSaveClick = { newIme, newPrezime, newGodinaUpisa ->
                    libraryViewModel.addMember(newIme, newPrezime, newGodinaUpisa)
                },
                onBackClick = {
                    navController.popBackStack()
                },
                navController = navController
            )
        }

        composable(Routes.MEMBER_DETAILS) {
            LibraryMemberDetailsScreen(
                member = libraryViewModel.selectedMember.value,
                books = libraryViewModel.books.value,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        //TODO: Add required navigation
    }
}