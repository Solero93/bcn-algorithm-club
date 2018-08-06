package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IslandsTest {

    private Islands islands;
    private char[][] grid;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}
                        }, 1
                },
                {
                        new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}
                        }, 3
                }
        });
    }

    public IslandsTest(char[][] grid, int expectedResult) {
        this.grid = grid;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        islands = new Islands();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(islands.numIslands(grid)).isEqualTo(expectedResult);
    }
}