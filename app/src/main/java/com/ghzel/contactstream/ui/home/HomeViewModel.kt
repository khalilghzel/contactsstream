package com.ghzel.contactstream.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.addinn.smartclaimexpert.ui.composables.auth.signin.HomeUiState
import com.ghzel.domain.contacts.usecases.GetAllContactsUseCase
import com.ghzel.domain.contacts.usecases.SyncContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllContactsUseCase: GetAllContactsUseCase,
    private val syncContactUseCase: SyncContactUseCase,
    ) :
    ViewModel() {

    private val _stateData = mutableStateOf(ContactsDataState())
    val stateData: State<ContactsDataState> = _stateData

    private val _stateUi = mutableStateOf(HomeUiState())
    val stateUi: State<HomeUiState> = _stateUi

    // updating the data state with contacts
    fun getAllContacts(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            getAllContactsUseCase.invoke(query)
                .collect {
                    _stateData.value = ContactsDataState(isLoading = false, data = it)
                }

        }
    }
    // Syncing data from the phone contacts to the local database
    fun syncContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            syncContactUseCase.invoke()
        }
    }

    init {
        //searching from database after giving a second to the user for inserting the search query
        snapshotFlow { _stateUi.value.search.value }.debounce(1000L)
            .onEach {
                getAllContacts(it)
            }
            .launchIn(viewModelScope)
    }
}