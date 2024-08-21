package com.ksknt.test.mob.and.appcontainer.unscramble

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class UnscrambleGameUiState(
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 0,
    val score: Int = 0,
    val isGameOver: Boolean = false,
    val isGameStarted: Boolean = false
)

class UnscrambleViewModel: ViewModel() {

    private lateinit var currentWord: String
    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()


    private val _uiState = MutableStateFlow(UnscrambleGameUiState())
    val uiState: StateFlow<UnscrambleGameUiState> = _uiState.asStateFlow()

    init {
        resetGame()
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }
    fun resetGame() {
        usedWords.clear()
        _uiState.value = UnscrambleGameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

}

