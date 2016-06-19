package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.BFS;
import fr.pasithee.jullerene.model.EdgeListsGraph;
import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.util.Node;
import fr.pasithee.jullerene.util.NodeFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BFSTest {

    List<Node> nodes;
    Graph<Node> k33;
    Graph<Node> disconnected;

    @Before
    public void setUp() {
        String[] values = new String[]{"v0", "v1", "v2", "v3", "v4", "v5"};
        nodes = NodeFactory.createNodes(values);

        k33 = new EdgeListsGraph<>();
        // bipartite between sets A = 0/1/2 and B = 3/4/5
        k33.addEdge(nodes.get(0), nodes.get(3));
        k33.addEdge(nodes.get(0), nodes.get(4));
        k33.addEdge(nodes.get(0), nodes.get(5));
        k33.addEdge(nodes.get(1), nodes.get(3));
        k33.addEdge(nodes.get(1), nodes.get(4));
        k33.addEdge(nodes.get(1), nodes.get(5));
        k33.addEdge(nodes.get(2), nodes.get(3));
        k33.addEdge(nodes.get(2), nodes.get(4));
        k33.addEdge(nodes.get(2), nodes.get(5));

        disconnected = new EdgeListsGraph<>();
        // two components path 0-1-2 / cycle 3-4-5
        disconnected.addEdge(nodes.get(0), nodes.get(1));
        disconnected.addEdge(nodes.get(1), nodes.get(2));
        disconnected.addEdge(nodes.get(3), nodes.get(4));
        disconnected.addEdge(nodes.get(3), nodes.get(5));
        disconnected.addEdge(nodes.get(4), nodes.get(5));
    }

    @Test
    public void BFSStepWithSingleNodeGraphShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        Map<Node, Integer> expected = new HashMap<>();
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithNoNodeGraphShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        Map<Node, Integer> expected = new HashMap<>();
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithTwoNodesOneUndirectedEdgeShouldWork() {
        Graph<Node> g = new EdgeListsGraph<>();
        g.setDirected(false);

        String[] values = new String[]{"v0", "v1"};
        List<Node> nodes = NodeFactory.createNodes(values);

        g.addEdge(nodes.get(0), nodes.get(1));
        Map<Node, Integer> expected = new HashMap<>();
        expected.put(nodes.get(0), 0);
        expected.put(nodes.get(1), 1);
        BFS<Node> bfs = new BFS<>(g);
        assertEquals(expected, bfs.step());
    }

    @Test
    public void BFSStepWithK33ShouldWork() {
        BFS<Node> bfs = new BFS<>(k33);

        Map<Node, Integer> result = bfs.step();
        int firstNodeIndex = -1;
        for (Map.Entry<Node, Integer> kv : result.entrySet()) {
            if (kv.getValue() == 0) {
                firstNodeIndex = nodes.indexOf(kv.getKey());
                break;
            }
        }

        assertTrue(firstNodeIndex != -1);

        if (firstNodeIndex < 3) {
            assertTrue(firstNodeIndex == 0 || (result.get(nodes.get(0)) >= 4));
            assertTrue(firstNodeIndex == 1 || (result.get(nodes.get(1)) >= 4));
            assertTrue(firstNodeIndex == 2 || (result.get(nodes.get(2)) >= 4));
            assertTrue(result.get(nodes.get(3)) > 0 && result.get(nodes.get(3)) < 4);
            assertTrue(result.get(nodes.get(4)) > 0 && result.get(nodes.get(4)) < 4);
            assertTrue(result.get(nodes.get(5)) > 0 && result.get(nodes.get(5)) < 4);
        } else {
            assertTrue(firstNodeIndex == 3 || (result.get(nodes.get(3)) >= 4));
            assertTrue(firstNodeIndex == 4 || (result.get(nodes.get(4)) >= 4));
            assertTrue(firstNodeIndex == 5 || (result.get(nodes.get(5)) >= 4));
            assertTrue(result.get(nodes.get(0)) > 0 && result.get(nodes.get(0)) < 4);
            assertTrue(result.get(nodes.get(1)) > 0 && result.get(nodes.get(1)) < 4);
            assertTrue(result.get(nodes.get(2)) > 0 && result.get(nodes.get(2)) < 4);
        }
    }

    @Test
    public void BFSStepWithDisconnectedGraphShouldWork() {
        BFS<Node> bfs = new BFS<>(disconnected);
        Map<Node, Integer> result = bfs.step();
        if (result.get(nodes.get(0)) != -1) {
            assertTrue(result.get(nodes.get(1)) != -1);
            assertTrue(result.get(nodes.get(2)) != -1);
            assertTrue(result.get(nodes.get(3)) == -1);
            assertTrue(result.get(nodes.get(4)) == -1);
            assertTrue(result.get(nodes.get(5)) == -1);
        } else {
            assertTrue(result.get(nodes.get(1)) == -1);
            assertTrue(result.get(nodes.get(2)) == -1);
            assertTrue(result.get(nodes.get(3)) != -1);
            assertTrue(result.get(nodes.get(4)) != -1);
            assertTrue(result.get(nodes.get(5)) != -1);
        }
    }

    @Test
    public void traversalWithK33ShouldWork() {
        BFS<Node> bfs = new BFS<>(k33);
        Map<Node, Integer> result = bfs.traversal();
        int firstNodeIndex = -1;
        for (Map.Entry<Node, Integer> kv : result.entrySet()) {
            if (kv.getValue() == 0) {
                firstNodeIndex = nodes.indexOf(kv.getKey());
                break;
            }
        }

        assertTrue(firstNodeIndex != -1);

        if (firstNodeIndex < 3) {
            assertTrue(firstNodeIndex == 0 || (result.get(nodes.get(0)) >= 4));
            assertTrue(firstNodeIndex == 1 || (result.get(nodes.get(1)) >= 4));
            assertTrue(firstNodeIndex == 2 || (result.get(nodes.get(2)) >= 4));
            assertTrue(result.get(nodes.get(3)) > 0 && result.get(nodes.get(3)) < 4);
            assertTrue(result.get(nodes.get(4)) > 0 && result.get(nodes.get(4)) < 4);
            assertTrue(result.get(nodes.get(5)) > 0 && result.get(nodes.get(5)) < 4);
        } else {
            assertTrue(firstNodeIndex == 3 || (result.get(nodes.get(3)) >= 4));
            assertTrue(firstNodeIndex == 4 || (result.get(nodes.get(4)) >= 4));
            assertTrue(firstNodeIndex == 5 || (result.get(nodes.get(5)) >= 4));
            assertTrue(result.get(nodes.get(0)) > 0 && result.get(nodes.get(0)) < 4);
            assertTrue(result.get(nodes.get(1)) > 0 && result.get(nodes.get(1)) < 4);
            assertTrue(result.get(nodes.get(2)) > 0 && result.get(nodes.get(2)) < 4);
        }
    }

    @Test
    public void BFSWithDisconnectedGraphShouldWork() {
        BFS<Node> bfs = new BFS<>(disconnected);
        Map<Node, Integer> result = bfs.traversal();
        if (result.get(nodes.get(0)) < 3) {
            assertTrue(result.get(nodes.get(1)) < 3 && result.get(nodes.get(1)) >= 0);
            assertTrue(result.get(nodes.get(2)) < 3 && result.get(nodes.get(2)) >= 0);
            assertTrue(result.get(nodes.get(3)) >= 3);
            assertTrue(result.get(nodes.get(4)) >= 3);
            assertTrue(result.get(nodes.get(5)) >= 3);
        } else {
            assertTrue(result.get(nodes.get(1)) >= 3);
            assertTrue(result.get(nodes.get(2)) >= 3);
            assertTrue(result.get(nodes.get(3)) < 3 && result.get(nodes.get(3)) >= 0);
            assertTrue(result.get(nodes.get(4)) < 3 && result.get(nodes.get(4)) >= 0);
            assertTrue(result.get(nodes.get(5)) < 3 && result.get(nodes.get(5)) >= 0);
        }
    }

}
