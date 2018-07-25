package com.bcnalgorithmclub.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayWalk {

    static int ROW;
    static int COL;

    static class Point {
        int row;
        int col;

        public Point(int i, int y) {
            this.row = i;
            this.col = y;
        }
    }

    static class QueueNode {
        Point pt;
        int dist;

        public QueueNode(Point source, int dis) {
            this.pt = source;
            this.dist = dis;
        }
    }


    public static void main(String[] args) {

        ROW = 9;
        COL = 10;
        int mat[][] = new int[][]
                {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
                };

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = BFS(mat, source, dest);

        System.out.println(dist);

    }

    private static int BFS(int[][] mat, Point source, Point dest) {

        if (mat[source.row][source.col] == 0 || mat[dest.row][dest.col] == 0)
            return Integer.MAX_VALUE;


        boolean visited[][] = new boolean[ROW][COL];

        visited[source.row][source.col] = true;

        Queue<QueueNode> queueNodes = new LinkedList<>();
        queueNodes.add(new QueueNode(source, 0));


        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};


        while (!queueNodes.isEmpty()) {

            QueueNode curr = queueNodes.peek();
            Point pt = curr.pt;

            if (pt.row == dest.row && pt.col == dest.col) {
                return curr.dist;
            }

            queueNodes.poll();

            for (int i = 0; i < 4; i++) {
                int row = pt.row + rowNum[i];
                int col = pt.col + colNum[i];

                if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    queueNodes.add(new QueueNode(new Point(row, col), curr.dist + 1));
                }
            }

        }

        return Integer.MAX_VALUE;
    }

    static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW)
                && (col >= 0) && (col < COL);
    }
}
