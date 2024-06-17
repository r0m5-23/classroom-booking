@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.classroombooking.presentation.features.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBarUI(
    modifier: Modifier = Modifier,
    placeholder: String,
) {
    var text by remember {
        mutableStateOf("")
    }
    val isVisible by remember {
        derivedStateOf { text.isNotBlank() }
    }

    SearchBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 64.dp),
        inputField = {
            SearchBarDefaults.InputField(
                query = text,
                onQueryChange = {
                    text = it.trim()
                } ,
                onSearch = {},
                expanded = false,
                onExpandedChange = {},
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Gray,
                        fontSize = 20.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    AnimatedVisibility(
                        visible = isVisible,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    text = ""
                                }
                        )
                    }
                }
            )
        },
        expanded = false,
        onExpandedChange = {},
        shape = RoundedCornerShape(16.dp)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarUIPreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        SearchBarUI(
            placeholder = "Search classroom",
        )
    }
}