package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DifferenceTest {
    private Difference difference;
    private TreeNode root;
    private int expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {

        TreeNode root = new TreeNode(1);

        TreeNode firstNode = new TreeNode(3);
        TreeNode secondNode = new TreeNode(2);

        root.right = firstNode;
        firstNode.left = secondNode;

        return Arrays.asList(new Object[][]{
                {
                        root, 1
                }
        });
    }

    public DifferenceTest(TreeNode root, int expectedResult) {
        this.root = root;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        difference = new Difference();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(difference.getMinimumDifference(root)).isEqualTo(expectedResult);
    }
}
