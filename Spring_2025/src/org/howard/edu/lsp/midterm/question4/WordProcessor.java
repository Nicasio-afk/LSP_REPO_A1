package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a sentence to find all longest words.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructs a new WordProcessor with the specified sentence.
     *
     * @param sentence the sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     *
     * @return a list of the longest words in the order they appear
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }

        // Split the sentence into words, handling varying whitespace
        String[] words = sentence.split("\\s+");
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}