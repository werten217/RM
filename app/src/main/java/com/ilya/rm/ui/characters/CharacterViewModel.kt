package com.ilya.rm.ui.characters

import com.ilya.rm.data.model.character.Character
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.rm.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _selectedCharacter = MutableStateFlow<Character?>(null)
    val selectedCharacter: StateFlow<Character?> = _selectedCharacter

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
            }
        }
    }

    fun loadCharacterById(id: Int) {
        viewModelScope.launch {
            try {
                _selectedCharacter.value = repository.getCharacterById(id)
            } catch (e: Exception) {
            }
        }
    }
}