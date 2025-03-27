package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class WordleDictionaryTest {
    private static final String ONE_WORD_DICTIONARY_FILENAME = "/one_word_dictionary.txt";
    WordleDictionary testDictionary;

    @BeforeEach
    public void setupTestDictionary() {
        testDictionary = new WordleDictionary();
    }

    @Test
    public void testOneWordDictionary() {
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals(1, testDictionary.getDictionarySize());
        assertTrue(testDictionary.containsWord("BALDY"));
    }


    /*
     * testing legalWordleWord with different cases to see how case sensitivity affects acceptance
     * testing all lowercase letters - heart - failing
     */
    @Test
    public void testIsLegalWordleWord() {
        assertTrue(testDictionary.isLegalWordleWord("heart"));
    }

    /*
     * testing first letter uppercase - Black - passing
     */
    @Test
    public void testIsLegalWordleWordFirstLetter() {
        assertTrue(testDictionary.isLegalWordleWord("Black"));
    }

    /*
     * testing mixed letter cases - tOwEL - failing
     */
    @Test
    public void testIsLegalWordleWordMixedLetters() {
        assertTrue(testDictionary.isLegalWordleWord("tOwEL"));
    }

    /*
     * testing all uppercase letters - GLASS - passing
     */
    @Test
    public void testIsLegalWordleWordUppercaseOnly() {
        assertTrue(testDictionary.isLegalWordleWord("GLASS"));
    }

    /*
     * testing edge cases for isLegalWordleWord - testing words starting with A
     */
    @Test
    public void testIsLegalWordleWordStartA() {
        assertTrue(testDictionary.isLegalWordleWord("apple"));
    }

    /*
     * testing edge cases for isLegalWordleWord - testing words starting with Z
     */
    @Test
    public void testIsLegalWordleWordStartZ() {
        assertTrue(testDictionary.isLegalWordleWord("Zebra"));
    }

    /*
     * testing for words with first letter, but rest symbols
     */
    @Test
    public void testIsLegalWordleWordStartLetterIncludeSymbol() {
        assertFalse(testDictionary.isLegalWordleWord("M!@?%"));
    }


    /*
     * testing addWord to check the IllegalWordExcpetion is thrown accurately
     */
    @Test
    public void testAddWordThrowsIllegalWordException() {
        try{
            testDictionary.addWord("checking");
        } catch(IllegalWordException e) {

        }
    }

    /*
            * testing if IsLegalWordleWord handles null input properly
     */
    @Test
    public void testIsLegalWordleWordNull() {
        assertFalse(testDictionary.isLegalWordleWord(null));
    }

    /*
     * testing if IsLegalWordleWord handles ASCII values greater than Z properly
     */
    @Test
    public void testIsLegalWordleWordNoLetters() {
        assertFalse(testDictionary.isLegalWordleWord("~~~~~"));
    }

}
