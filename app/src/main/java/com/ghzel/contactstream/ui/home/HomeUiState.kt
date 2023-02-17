package com.addinn.smartclaimexpert.ui.composables.auth.signin

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


// this class is for saving the composable states
// we could have saved it directly in the home screen but i prefer to save the states in the viewmodel for better performance
data class HomeUiState(
    val search: MutableState<String> =  mutableStateOf("")
)
