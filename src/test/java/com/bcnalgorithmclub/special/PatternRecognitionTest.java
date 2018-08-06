package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PatternRecognitionTest {
    private PatternRecognition patternRecognition;
    private String pattern;
    private String word;
    private boolean expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        "abba", "dog cat cat dog", true
                },
                {
                        "abba", "dog cat cat fish", false
                },
                {
                        "aaaa", "dog cat cat dog", false
                },
                {
                        "abba", "dog dog dog dog", false
                },
                {
                        "aaaa", "dog dog dog dog", true
                }
        });
    }

    public PatternRecognitionTest(String pattern, String word, boolean expectedResult) {
        this.pattern = pattern;
        this.word = word;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        patternRecognition = new PatternRecognition();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(patternRecognition.wordPattern(pattern, word)).isEqualTo(expectedResult);
    }
}
