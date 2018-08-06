package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MajorityTest {
    private Majority majority;
    private int[] nums;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{2, 3, 2}, 3
                },
                {
                        new int[]{2, 2, 1, 1, 1, 2, 2}, 2
                }
        });
    }

    public MajorityTest(int[] nums, int expectedResult) {
        this.nums = nums;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        majority = new Majority();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(majority.majorityElement(nums)).isEqualTo(expectedResult);
    }
}
