package com.ilya.rm.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.rm.data.model.episode.Episode
import com.ilya.rm.data.repository.EpisodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel(private val repository: EpisodeRepository) : ViewModel() {

    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    private val _selectedEpisode = MutableStateFlow<Episode?>(null)
    val selectedEpisode: StateFlow<Episode?> = _selectedEpisode

    fun loadEpisodes() {
        viewModelScope.launch {
            try {
                val response = repository.getEpisodes()
                _episodes.value = response.results
            } catch (e: Exception) {
            }
        }
    }

    fun loadEpisodeById(id: Int) {
        viewModelScope.launch {
            try {
                _selectedEpisode.value = repository.getEpisodeById(id)
            } catch (e: Exception) {
            }
        }
    }
}