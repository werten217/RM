package com.ilya.rm.ui.test

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTopAppBarScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hello TopAppBar") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text("Содержимое экрана ниже TopAppBar")
        }
    }
}

