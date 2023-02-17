package com.ghzel.contactstream.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ghzel.contactstream.theme.AppMainTheme
import com.ghzel.contactstream.theme.Permission
import com.ghzel.contactstream.ui.home.components.ContactList
import com.ghzel.contactstream.ui.home.components.Toolbar
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("Range")
@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val viewModel: HomeViewModel = hiltViewModel()
    val dataState = viewModel.stateData.value
    val uiState = viewModel.stateUi.value
    val context = LocalContext.current
    Permission(
        permission = Manifest.permission.READ_CONTACTS,
        permissionNotAvailableContent = {
        },
    ) {
        LaunchedEffect(true) {
            // we use a launched effect with a constant key in order to sync the data only when creating the screen
            // if we don't use launched effect the data will be synced in every screen recomposition
            viewModel.syncContacts()
        }
    }
    AppMainTheme(
        displayProgressBar =dataState.isLoading,
        scaffoldState = scaffoldState
    ) {
        Column() {
            // toolbar component with search listner
            Toolbar(onSearchChanged = { uiState.search.value = it })


            //component for showing the contacts in a list
            ContactList(
                contacts = dataState.data,
                onClickListener = {
                    val u = Uri.parse("tel:" + it.number)

                    val i = Intent(Intent.ACTION_DIAL, u)
                    try {

                        // Launch the Phone app's dialer with a phone number to dial a call.
                        context.startActivity(i)
                    } catch (s: SecurityException) {
                        Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG)
                            .show()
                }
                }
            )
        }
    }
}