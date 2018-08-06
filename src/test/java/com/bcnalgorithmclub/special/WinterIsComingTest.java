package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WinterIsComingTest {

    private WinterIsComing winterIsComing;
    private int[] houses;
    private int[] heaters;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 2, 3}, new int[]{2}, 1
                },
                {
                        new int[]{1, 2, 3, 4}, new int[]{1, 4}, 1
                }
        });
    }

    public WinterIsComingTest(int[] houses, int[] heaters, int expectedResult) {
        this.houses = houses;
        this.heaters = heaters;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        winterIsComing = new WinterIsComing();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(winterIsComing.findRadius(houses, heaters)).isEqualTo(expectedResult);
    }
}