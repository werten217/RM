package com.ilya.rm.data.model.character

import com.ilya.rm.data.model.Info

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)
