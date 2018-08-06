package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TasksTest {
    private Tasks task;
    private char[] tasks;
    private int n;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8
                }
        });
    }

    public TasksTest(char[] tasks, int n, int expectedResult) {
        this.tasks = tasks;
        this.n = n;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        task = new Tasks();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(task.leastInterval(tasks, n)).isEqualTo(expectedResult);
    }
}