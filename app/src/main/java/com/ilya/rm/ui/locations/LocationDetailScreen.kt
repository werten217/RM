package com.ilya.rm.ui.locations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun LocationDetailScreen(
    locationId: Int,
    modifier: Modifier = Modifier,
    viewModel: LocationViewModel = getViewModel()
) {
    val location by viewModel.selectedLocation.collectAsState()

    LaunchedEffect(locationId) {
        viewModel.loadLocationById(locationId)
    }

    location?.let {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${it.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Type: ${it.type}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Dimension: ${it.dimension}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Residents: ${it.residents.size}")
        }
    } ?: run {
        Text(text = "Loading...")
    }
}