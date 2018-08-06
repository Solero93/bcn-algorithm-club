package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StonesTest {
    private Stones stones;
    private String J;
    private String S;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        "aA", "aAAbbbb", 3
                },
                {
                        "z", "ZZ", 0
                }
        });
    }

    public StonesTest(String J, String S, int expectedResult) {
        this.J = J;
        this.S = S;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        stones = new Stones();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(stones.numJewelsInStones(J, S)).isEqualTo(expectedResult);
    }
}