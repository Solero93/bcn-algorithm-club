package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@RunWith(Parameterized.class)
public class LettersTest {
    private Letters letters;
    private String s;
    private List<String> expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        "a1b2", Lists.newArrayList("a1b2", "a1B2", "A1b2", "A1B2")
                },
                {
                        "3z4", Lists.newArrayList("3z4", "3Z4")
                },
                {
                        "12345", Lists.newArrayList("12345")
                }
        });
    }

    public LettersTest(String s, List<String> expectedResult) {
        this.s = s;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        letters = new Letters();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(letters.letterCasePermutation(s).size()).isEqualTo(expectedResult.size());
        Assertions.assertThat(letters.letterCasePermutation(s)).containsExactlyElementsOf(expectedResult);
    }
}
