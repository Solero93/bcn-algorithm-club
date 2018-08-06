package com.bcnalgorithmclub.special;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class PathsTest {
    private Paths paths;
    private TreeNode root;
    private int sum;
    private boolean expectedResult;


    @Parameterized.Parameters
    public static Collection primeNumbers() {

        TreeNode root = new TreeNode(5);

        TreeNode firstNode = new TreeNode(4);
        TreeNode secondNode = new TreeNode(8);

        root.left = firstNode;
        root.right = secondNode;

        TreeNode thirdNode = new TreeNode(11);
        firstNode.left = thirdNode;


        TreeNode fourthNode = new TreeNode(13);
        TreeNode fifthNode = new TreeNode(4);

        secondNode.left = fourthNode;
        secondNode.right = fifthNode;


        TreeNode sixNode = new TreeNode(7);
        TreeNode seventhNode = new TreeNode(2);
        TreeNode eightNode = new TreeNode(1);

        thirdNode.left = sixNode;
        thirdNode.right = seventhNode;

        fifthNode.right = eightNode;


        return Arrays.asList(new Object[][]{
                {
                        root, 22, true
                }
        });
    }

    public PathsTest(TreeNode root, int sum, boolean expectedResult) {
        this.root = root;
        this.sum = sum;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        paths = new Paths();
    }

    @Test
    public void testSmallData() {
        Assertions.assertThat(paths.hasPathSum(root, sum)).isEqualTo(expectedResult);
    }
}
