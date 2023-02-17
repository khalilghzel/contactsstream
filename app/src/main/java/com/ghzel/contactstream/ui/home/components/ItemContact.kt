package com.ghzel.contactstream.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ghzel.contactstream.theme.DarkBlue
import com.ghzel.contactstream.theme.TextColor
import com.ghzel.domain.contacts.dto.ContactModel


@Composable
fun ItemContact(
    contact: ContactModel,
    onClicked: () -> Unit,
) {

            Column( modifier = Modifier
                .fillMaxWidth().clickable { onClicked() }
                .padding(15.dp, 10.dp),) {
                Text(
                    text = contact.name,
                    color = TextColor,
                    modifier = Modifier.padding(0.dp, 2.dp),
                    style =  MaterialTheme.typography.displayMedium
                )
                Text(
                    text = contact.number,
                    color = TextColor,
                    modifier = Modifier.padding(0.dp, 2.dp),
                    style = MaterialTheme.typography.bodyMedium
                )

            }


         }




