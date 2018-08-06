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
public class NumbersTest {
    private Numbers numbers;
    private int left;
    private int right;
    private List<Integer> expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        1, 22, Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)
                }
        });
    }

    public NumbersTest(int left, int right, List<Integer> expectedResult) {
        this.left = left;
        this.right = right;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        numbers = new Numbers();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(numbers.selfDividingNumbers(left, right).size()).isEqualTo(expectedResult.size());
        Assertions.assertThat(numbers.selfDividingNumbers(left, right)).containsExactlyElementsOf(expectedResult);
    }
}
