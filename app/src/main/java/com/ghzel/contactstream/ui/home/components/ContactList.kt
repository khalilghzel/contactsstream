package com.ghzel.contactstream.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ghzel.domain.contacts.dto.ContactModel


@Composable
fun ContactList(

    contacts: List<ContactModel>,
    onClickListener: (ContactModel) -> Unit,
) {
    Box(
        modifier =Modifier
            .fillMaxSize()
    ) {
        LazyColumn() {
            items(items =  contacts   ) { item ->
                ItemContact(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .animateItemPlacement(),
                    contact = item,
                    onClicked = { onClickListener(item) }
                )
            }
        }
    }
}







