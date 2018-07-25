package com.bcnalgorithmclub.graphs;

import com.bcnalgorithmclub.graphs.maxflow.MaximumFlow;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MaximumFlowTest {

    @Test
    public void fordFulkerson() {

        int graph[][] = new int[][]{
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        MaximumFlow m = new MaximumFlow();
        int maxFlow = m.fordFulkerson(graph, 0, 5);

        Assertions.assertThat(maxFlow).isEqualTo(23);
    }


    @Test
    public void fordFulkersonTest2() {

        int graph[][] = new int[][]{
                {0, 10, 10, 0, 0, 0},
                {0, 0, 2, 4, 8, 0},
                {0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 0, 10},
                {0, 0, 0, 6, 0, 10},
                {0, 0, 0, 0, 0, 0}
        };

        MaximumFlow m = new MaximumFlow();
        int maxFlow = m.fordFulkerson(graph, 0, 5);

        Assertions.assertThat(maxFlow).isEqualTo(19);
    }
}