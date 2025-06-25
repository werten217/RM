package com.ilya.rm.ui.episodes

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
fun EpisodesScreen(
    modifier: Modifier = Modifier,
    viewModel: EpisodeViewModel = getViewModel(),
    onEpisodeClick: (Int) -> Unit
) {
    val episodes by viewModel.episodes.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadEpisodes()
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(episodes) { episode ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onEpisodeClick(episode.id) }
                    .padding(8.dp)
            ) {
                Text(text = episode.name)
                Text(text = "Air date: ${episode.air_date}")
                Text(text = episode.episode)
            }
        }
    }
}