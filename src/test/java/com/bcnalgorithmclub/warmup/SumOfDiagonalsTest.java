package com.bcnalgorithmclub.warmup;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SumOfDiagonalsTest {

    private SumOfDiagonals warmUp;
    private int[][] inputNumber;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}}, 15
                },
                {
                        new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 0
                },
                {
                        new int[][]{{1, 1}, {1, 1}}, 0
                },
                {
                        new int[][]{{123, 3, -100}, {2, 0, 2}, {7, 90, 0}}, 216
                },
                {
                        new int[][]{{5, -12}, {-12, -10}}, 19
                }
        });
    }

    public SumOfDiagonalsTest(int[][] inputNumber, int expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        warmUp = new SumOfDiagonals();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(warmUp.solve(inputNumber)).isEqualTo(expectedResult);
    }
}