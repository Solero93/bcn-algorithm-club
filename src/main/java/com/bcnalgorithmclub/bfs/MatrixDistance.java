package com.bcnalgorithmclub.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixDistance {

    static class Location {
        int row;
        int col;
        int dist;

        Location(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }


    public static void main(String[] args) {
        Location source = new Location(0, 1, 0);
        char[][] matrix = new char[][]{
                {'.', 'c', '.', '.'},
                {'.', 'X', 'X', '.'},
                {'p', '.', 'p', '.'},
                {'X', '.', '.', 'p'}
        };

        new MatrixDistance().minDistance(matrix, source);
    }


    void minDistance(char[][] matrix, Location source) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        List<Location> parking = new ArrayList<>();

        Queue<Location> queue = new LinkedList<>();
        (queue).add(source);
        visited[source.row][source.col] = true;

        while (!queue.isEmpty()) {

            Location p = queue.poll();

            if (matrix[p.row][p.col] == 'p')
                parking.add(p);

            // moving up
            if (p.row - 1 >= 0 && !visited[p.row - 1][p.col] && matrix[p.row - 1][p.col] != 'X') {
                queue.add(new Location(p.row - 1, p.col, p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (p.row + 1 < matrix.length && !visited[p.row + 1][p.col] && matrix[p.row + 1][p.col] != 'X') {
                queue.add(new Location(p.row + 1, p.col, p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (p.col - 1 >= 0 && !visited[p.row][p.col - 1] && matrix[p.row][p.col - 1] != 'X') {
                queue.add(new Location(p.row, p.col - 1, p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (p.col + 1 < matrix[0].length && !visited[p.row][p.col + 1] && matrix[p.row][p.col + 1] != 'X') {
                queue.add(new Location(p.row, p.col + 1, p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
    }
}
