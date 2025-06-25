package com.ilya.rm.ui.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterDetailScreen(
    characterId: Int,
    modifier: Modifier = Modifier,
    viewModel: CharacterViewModel = getViewModel()
) {
    val character by viewModel.selectedCharacter.collectAsState()

    LaunchedEffect(characterId) {
        viewModel.loadCharacterById(characterId)
    }

    character?.let {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(it.image),
                contentDescription = it.name,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${it.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Status: ${it.status}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Species: ${it.species}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Gender: ${it.gender}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Origin: ${it.origin.name}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Location: ${it.location.name}")
        }
    } ?: run {
        Text(text = "Loading...")
    }
}