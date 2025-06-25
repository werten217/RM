package com.ilya.rm.data.repository
import com.ilya.rm.data.model.character.Character
import com.ilya.rm.data.model.character.CharacterResponse
import com.ilya.rm.data.network.CharacterApiService

class CharacterRepository(private val api: CharacterApiService) {

    suspend fun getCharacters(page: Int = 1): CharacterResponse {
        return api.getCharacters(page)
    }

    suspend fun getCharacterById(id: Int): Character {
        return api.getCharacterById(id)
    }
}