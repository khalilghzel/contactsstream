package com.ghzel.contactstream.ui.home

import com.ghzel.domain.contacts.dto.ContactModel

// this class is for holding the contacts data state
// is loading is actually unnecessary since loading the data from the local database won't take too long
data class ContactsDataState(
    val isLoading: Boolean = false,
    val data: List<ContactModel>  = listOf()
)
