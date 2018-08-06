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
public class FrequencyTest {
    private Frequency frequency;
    private int[] nums;
    private int k;
    private List<Integer> expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 1, 1, 2, 2, 3}, 2, Lists.newArrayList(1, 2)
                }
        });
    }

    public FrequencyTest(int[] nums, int k, List<Integer> expectedResult) {
        this.nums = nums;
        this.k = k;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        frequency = new Frequency();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(frequency.topKFrequent(nums, k).size()).isEqualTo(expectedResult.size());
        Assertions.assertThat(frequency.topKFrequent(nums, k)).containsExactlyElementsOf(expectedResult);
    }
}
