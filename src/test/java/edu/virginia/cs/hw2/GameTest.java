package edu.virginia.cs.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    @Test
    public void testConstructorWithIllegalAnswer() {
        assertThrows(IllegalWordException.class,
                () -> new GameState("QZXYX"));
    }

    @Test
    public void testSubmitGuessWon() {
        testGame = new GameState("aback");
        testGame.submitGuess("aback");
        assertTrue(testGame.isWin());
    }

    @Test
    public void testSubmitGuessInvalidWord() {
        testGame = new GameState("aback");
        assertThrows(IllegalWordException.class, () -> testGame.submitGuess("xyzzy"));
    }

    @Test
    public void testSubmitGuessLost() {
        testGame = new GameState("aback");

        testGame.submitGuess("aahed");
        testGame.submitGuess("aalii");
        testGame.submitGuess("aargh");
        testGame.submitGuess("aaron");
        testGame.submitGuess("abaca");
        testGame.submitGuess("abaci");


        assertTrue(testGame.isLoss());
    }

    @Test
    public void testSubmitGuessPlaying() {
        testGame = new GameState("aback");

        testGame.submitGuess("aahed");
        testGame.submitGuess("aalii");
        testGame.submitGuess("aargh");
        testGame.submitGuess("aaron");


        assertEquals(2, testGame.getRemainingGuesses());
    }

    @Test
    public void testSubmitGuessGameAlreadyOverExcpetion() {
        testGame = new GameState("aback");

        testGame.submitGuess("aahed");
        testGame.submitGuess("aalii");
        testGame.submitGuess("aargh");
        testGame.submitGuess("aaron");
        testGame.submitGuess("abaca");
        testGame.submitGuess("abaci");



        assertThrows(GameAlreadyOverException.class, () -> testGame.submitGuess("abada"));
    }







}