package com.bcnalgorithmclub.graphs;

import java.util.AbstractMap;
import java.util.Map;

public class AllShortestPairsSolution {

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 3, 3},
                {3, 0, 9},
                {3, 9, 0}
        };

        int T = 1;

        //        int graph[][] = new int[][]{
        //                {0, Integer.MAX_VALUE, -2, Integer.MAX_VALUE},
        //                {4, 0, 3, Integer.MAX_VALUE},
        //                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 2},
        //                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, 0}
        //        };

        AllShortestPairsSolution allShortestPairsSolution = new AllShortestPairsSolution();
        Map.Entry<Integer, Integer>[][] entries = allShortestPairsSolution.floydWarshall(graph, T);

        for (int i = 0; i < entries.length; ++i) {
            for (int j = 0; j < entries.length; ++j) {
                if (entries[i][j].getKey() == Integer.MAX_VALUE)
                    System.out.print("INF");
                else
                    System.out.print(entries[i][j].getKey() + "," + entries[i][j].getValue() + "   ");
            }
            System.out.println();

        }
    }

    private Map.Entry<Integer, Integer>[][] floydWarshall(int[][] graph, int T) {
        int V = graph.length;

        Map.Entry<Integer, Integer>[][] dist = new Map.Entry[V][V];

        int[][] counters = new int[V][V];


        int sum = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                Map.Entry<Integer, Integer> entry =
                        new AbstractMap.SimpleEntry<>(graph[i][j], i);

                if (graph[i][j] != Integer.MAX_VALUE && i != j) {

                    counters[i][j] = 1;

                    if (counters[i][j] == T)
                        sum += graph[i][j];
                }
                dist[i][j] = entry;
            }
        }

        for (int k = 0; k < V; k++) {

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (dist[i][k].getKey() != Integer.MAX_VALUE && dist[k][j].getKey() != Integer.MAX_VALUE
                            && dist[i][k].getKey() + dist[k][j].getKey() < dist[i][j].getKey()) {


                        Map.Entry<Integer, Integer> entry =
                                new AbstractMap.SimpleEntry<>(dist[i][k].getKey() + dist[k][j].getKey(), dist[k][j].getValue());
                        counters[k][j]++;
                        counters[i][j]--;

                        if (counters[k][j] == T)
                            sum += graph[k][j];

                        if (counters[i][j] == T - 1)
                            sum -= graph[i][j];

                        dist[i][j] = entry;
                    }
                }
            }
        }

        return dist;
    }

}

