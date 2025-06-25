package com.ilya.rm.ui.locations

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun LocationsScreen(
    modifier: Modifier = Modifier,
    viewModel: LocationViewModel = getViewModel(),
    onLocationClick: (Int) -> Unit
) {
    val locations by viewModel.locations.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadLocations()
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(locations) { location ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onLocationClick(location.id) }
                    .padding(8.dp)
            ) {
                Text(text = location.name)
                Text(text = "Type: ${location.type}")
                Text(text = "Dimension: ${location.dimension}")
            }
        }
    }
}