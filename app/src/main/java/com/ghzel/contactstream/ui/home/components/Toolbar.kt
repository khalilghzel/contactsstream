package com.ghzel.contactstream.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ghzel.contactstream.theme.GreySC2
import com.ghzel.contactstream.theme.TextColor


@Composable
fun Toolbar(
    onSearchChanged: (String) -> Unit
) {
    val search = remember {
        mutableStateOf("")
    }
    val isVisible = remember {
        derivedStateOf {
            search.value.isNotBlank()
        }
    }
    Surface(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp),
        elevation = 4.dp,
        color = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                label = {
                    Text("Search", color = TextColor)
                },
                shape = RoundedCornerShape(10.dp),
                value = search.value,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = GreySC2,
                    cursorColor = Color.Black,
                    disabledLabelColor = TextColor,
                    textColor = TextColor,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    onSearchChanged(it)
                    search.value = it
                },
                trailingIcon = {
                    if (isVisible.value) {
                        IconButton(
                            onClick = {
                                search.value = ""
                                onSearchChanged("")
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear"
                            )
                        }
                    }
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
            )
        }
    }
}
