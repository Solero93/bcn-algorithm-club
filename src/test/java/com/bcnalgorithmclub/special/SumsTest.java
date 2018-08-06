package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SumsTest {
    private Sums sums;
    private int firstNumber;
    private int secondNumber;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        0, 2, 1
                },
                {
                        2, 5, -1
                },
                {
                        0, 5, -3
                }
        });
    }

    public SumsTest(int firstNumber, int secondNumber, int expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        sums = new Sums(new int[]{-2, 0, 3, -5, 2, -1});
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(sums.sumRange(firstNumber, secondNumber)).isEqualTo(expectedResult);
    }
}
