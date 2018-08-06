package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DecodingTest {
    private Decoding decoding;
    private String s;
    private String expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        "3[a]2[bc]", "aaabcbc"
                },
                {
                        "3[a2[c]]", "accaccacc"
                },
                {
                        "2[abc]3[cd]ef", "abcabccdcdcdef"
                }
        });
    }

    public DecodingTest(String s, String expectedResult) {
        this.s = s;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        decoding = new Decoding();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(decoding.decodeString(s)).isEqualTo(expectedResult);
    }
}
