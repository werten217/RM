package com.ilya.rm.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ilya.rm.ui.characters.CharacterDetailScreen
import com.ilya.rm.ui.characters.CharactersScreen
import com.ilya.rm.ui.episodes.EpisodeDetailScreen
import com.ilya.rm.ui.episodes.EpisodesScreen
import com.ilya.rm.ui.locations.LocationDetailScreen
import com.ilya.rm.ui.locations.LocationsScreen
import androidx.compose.foundation.layout.statusBarsPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "characters") {

        // Список персонажей
        composable("characters") {
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Characters") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                CharactersScreen(
                    modifier = Modifier.padding(paddingValues),
                    onCharacterClick = { id ->
                        navController.navigate("characterDetail/$id")
                    }
                )
            }
        }

        // Детали персонажа
        composable(
            route = "characterDetail/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Character Detail") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                CharacterDetailScreen(
                    characterId = characterId,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }

        // Список эпизодов
        composable("episodes") {
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Episodes") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                EpisodesScreen(
                    modifier = Modifier.padding(paddingValues),
                    onEpisodeClick = { id ->
                        navController.navigate("episodeDetail/$id")
                    }
                )
            }
        }

        // Детали эпизода
        composable(
            route = "episodeDetail/{episodeId}",
            arguments = listOf(navArgument("episodeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getInt("episodeId") ?: 0
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Episode Detail") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                EpisodeDetailScreen(
                    episodeId = episodeId,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }

        // Список локаций
        composable("locations") {
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Locations") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                LocationsScreen(
                    modifier = Modifier.padding(paddingValues),
                    onLocationClick = { id ->
                        navController.navigate("locationDetail/$id")
                    }
                )
            }
        }

        // Детали локации
        composable(
            route = "locationDetail/{locationId}",
            arguments = listOf(navArgument("locationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getInt("locationId") ?: 0
            Scaffold(
                topBar = {
                    TopAppBar(
                        modifier = Modifier.statusBarsPadding(),
                        title = { Text("Location Detail") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1E88E5),
                            titleContentColor = Color.White
                        )
                    )
                }
            ) { paddingValues ->
                LocationDetailScreen(
                    locationId = locationId,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}