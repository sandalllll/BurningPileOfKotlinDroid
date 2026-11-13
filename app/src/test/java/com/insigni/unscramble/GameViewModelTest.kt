package com.insigni.unscramble
import com.insigni.unscramble.data.MAX_NO_OF_WORDS
import org.junit.Test
import org.junit.Assert.*
import com.insigni.unscramble.data.SCORE_INCREASE
import com.insigni.unscramble.data.getUnscrambledWord
class GameViewModelTest {
    private val viewModel = GameViewModel()
    @Test
    fun gameViewModel_Initialization_FirstWordLoaded()
    {
        assert(getUnscrambledWord(viewModel.uiState.value.currentScrambledWord) != "");
    }
    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet()
    {
        viewModel.updateUserGuess("not zebra")
        viewModel.checkUserGuess()
        assert(viewModel.uiState.value.isGuessedWordWrong)
        viewModel.resetGame()
    }
    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly()
    {

        repeat(MAX_NO_OF_WORDS - 1){
            val sc = viewModel.uiState.value.score + SCORE_INCREASE;
            val cwc = viewModel.uiState.value.currentWordCount + 1;
            viewModel.updateUserGuess(getUnscrambledWord(viewModel.uiState.value.currentScrambledWord))
            viewModel.checkUserGuess()
            assert(!viewModel.uiState.value.isGuessedWordWrong);
            assert(!viewModel.uiState.value.isGameOver);
            assertEquals(viewModel.uiState.value.score, sc);
            assertEquals(viewModel.uiState.value.currentWordCount, cwc);
        }
        val sc = viewModel.uiState.value.score + SCORE_INCREASE;
        val cwc = viewModel.uiState.value.currentWordCount;
        viewModel.updateUserGuess(getUnscrambledWord(viewModel.uiState.value.currentScrambledWord))
        viewModel.checkUserGuess()
        assert(!viewModel.uiState.value.isGuessedWordWrong);
        assert(viewModel.uiState.value.isGameOver);
        assertEquals(viewModel.uiState.value.score, sc);
        assertEquals(viewModel.uiState.value.currentWordCount, cwc);
        viewModel.resetGame()
    }
    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased()
    {
        val sc = viewModel.uiState.value.score;
        val cwc = viewModel.uiState.value.currentWordCount + 1;
        viewModel.skipWord()
        assert(sc == viewModel.uiState.value.score);
        assert(cwc == viewModel.uiState.value.currentWordCount);
        viewModel.resetGame()
    }


    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset()  {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        currentGameUiState = viewModel.uiState.value
        // Утверждаем, что обновленное разгаданное слово является правильным.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Утверждаем, что очки обновились правильно.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}