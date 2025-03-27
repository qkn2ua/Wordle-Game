# HW2-Wordle

## Authors

* Asmita Kadam - qkn2ua
*

## High-Level Overview
All classes are in the package edu.virginia.cs.hw2. Here are the structure of the starter code:
* **Main Class:** 
  * `CommandLineWordle` - when you start the assignment, this will be unrunnable. Once you complete the assignment, you should be able to run this file to play Wordle. Consider this your "System test" class.
* **Core Functionality Classes:**
  * `GameState` - maintains the state of a Wordle Game.
  * `WordleDictionary` - used for maintaining a set of words, such as words that are legal guesses in Wordle. Words are typically added via file.
  * `GuessResult` - responsible for generating the "color" output of Wordle.  
  * `DefaultDictionaryFactory` - used for getting "default" dictionaries.
* **Enumerated Types:**
  * `LetterResult` - The result from a single cell (or letter) in Wordle
    * `LetterResult.GREEN` - 🟩 - matching letter, correct location
    * `LetterResult.YELLOW` - 🟨 - matching letter, incorrect location
    * `LetterResult.GRAY` - ⬜ - non-matching letter
  * `GameState.GameStatus` - only used internally in `GameState.java`
    * `GameStatus.PLAYING` - The game is still ongoing. Functions `isGameOver()`, `isWin()`, and `isLost()` all return false.
    * `GameStatus.WON` - The player ended the game by guessing the answer correctly. No more guesses can be submitted. Functions `isGameOver()` and `isWin()` return true, and `isLoss()` returns false.
    * `GameStatus.LOST` - The player ended the game by running out of guesses and lost. No more guesses can be submitted. Function `isGameOver()` and `isLoss()` return true, and `isWin()` returns false.
* **Exceptions**
  * `IllegalWordException` - a invalid wordle word is used. Four examples:
    * Adding a non-five letter word to WordleDictionary
    * Adding a word containing non-letters to WordleDictionary
    * Guessing a word not in that games's dictionary
    * Creating a game with an answer not in that game's dictionary
  * `GameAlreadyOverException` - submitting a guess to a Wordle GameState that has already ended in a win or a loss.
  * `EmptyDictionaryException` - attempting to perform and operation with an empty WordleDictionary that cannot be completed.
* **Test Classes**
  * `DefaultDictionaryFactoryTest` - tests for DefaultDictionaryFactory
  * `GameTest` - tests for GameState
  * `GuessResultTest` - tests for GuessResult
  * `WordleDictionaryTest` - tests for WordleDictionary

## A Note about DefaultDictionaryFactory
This class is used to create "default" dictionaries for Wordle. It has two public functions:
* `getDefaultGuessesDictionary()` - Get the default "acceptable guesses" dictionary. 
  * This dictionary in theory contains all five letter words in the English language. Many of these words are obscure, and so it's not suitable to use this dictionary to generate random answers. For instance, it contains words like: _aahed_, _zunis_, _tares_, and _ergot_.
  * Loads from `src/main/resources/dictionary.txt`
  * If working correctly, the returned dictionary has 15920 words
* `getDefaultAnswersDictionary()` - Get the default "answers" dictionary. This dictionary is the original list of possible answers created by Wordle creator Josh Wardle. This dictionary can be used by GameState's constructor to select a random answer (generally, in testing, you should specify your own answer, avoid randomness).
  * Loads from src/main/resources/dictionary.txt
  * If working correctly, the returned dictionary has 2315 words

* Usage Example:
  * `DefaultDictionaryFactory factory = new DefaultDictionaryFactory();`
  * `WordleDictionary dict = factory.getDefaultGuessesDictionary();`

