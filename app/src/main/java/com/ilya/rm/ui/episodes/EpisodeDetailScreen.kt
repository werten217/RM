package com.ilya.rm.ui.episodes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun EpisodeDetailScreen(
    episodeId: Int,
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = getViewModel()
) {
    val episode by viewModel.selectedEpisode.collectAsState()

    LaunchedEffect(episodeId) {
        viewModel.loadEpisodeById(episodeId)
    }

    episode?.let {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Name: ${it.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Air date: ${it.air_date}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Episode: ${it.episode}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Characters: ${it.characters.size}")
        }
    } ?: run {
        Text(text = "Loading...")
    }
}