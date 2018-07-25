package com.bcnalgorithmclub.graphs.maxflow;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumFlow {

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 4, 4, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 4, 0, 0},
                {0, 0, 0, 0, 4, 0, 5, 0},
                {0, 0, 0, 0, 4, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        MaximumFlow m = new MaximumFlow();
        System.out.println("The maximum possible flow is " + m.fordFulkerson(graph, 0, 7));
    }

    public int fordFulkerson(int[][] graph, int source, int sink) {
        int V = graph.length;

        int rGraph[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            System.arraycopy(graph[i], 0, rGraph[i], 0, V);

        int parent[] = new int[V];
        int maxFlow = 0;

        while (bfs(rGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v])
                pathFlow = Math.min(pathFlow, rGraph[parent[v]][v]);

            for (int v = sink; v != source; v = parent[v]) {
                rGraph[parent[v]][v] -= pathFlow;
                rGraph[v][parent[v]] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean bfs(int[][] rGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[rGraph.length];

        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(source);
        visited[source] = true;
        parent[source] = -1;


        int current;
        while (!bfsQueue.isEmpty()) {
            current = bfsQueue.poll();
            for (int i = 0; i < rGraph[current].length; i++) {
                if (rGraph[current][i] != 0 && !visited[i]) {
                    bfsQueue.add(i);
                    visited[i] = true;
                    parent[i] = current;
                }
            }
            if (visited[sink]) {
                return true;
            }
        }

        return false;
    }
}
