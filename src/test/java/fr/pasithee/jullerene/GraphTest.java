package fr.pasithee.jullerene;

import fr.pasithee.jullerene.model.Graph;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    @Test
    public void hasEdgeWithUndirectedEdgesShouldReturnCorrectValues() {
        Graph g = new Graph(4);
        g.addUndirectedEdge(g.get(0), g.get(1));
        g.addUndirectedEdge(g.get(0), g.get(2));
        g.addUndirectedEdge(g.get(0), g.get(3));

        assertTrue(g.hasEdge(g.get(0), g.get(1)));
        assertTrue(g.hasEdge(g.get(0), g.get(2)));
        assertTrue(g.hasEdge(g.get(0), g.get(3)));
        assertTrue(g.hasEdge(g.get(1), g.get(0)));
        assertTrue(g.hasEdge(g.get(2), g.get(0)));
        assertTrue(g.hasEdge(g.get(3), g.get(0)));
        assertFalse(g.hasEdge(g.get(1), g.get(2)));
        assertFalse(g.hasEdge(g.get(1), g.get(3)));
        assertFalse(g.hasEdge(g.get(2), g.get(1)));
        assertFalse(g.hasEdge(g.get(2), g.get(3)));
        assertFalse(g.hasEdge(g.get(3), g.get(1)));
        assertFalse(g.hasEdge(g.get(3), g.get(2)));
    }

    @Test
    public void hasEdgeWithDirectedEdgesShouldReturnCorrectValues() {
        Graph g = new Graph(4);
        g.addDirectedEdge(g.get(0), g.get(1));
        g.addDirectedEdge(g.get(0), g.get(2));
        g.addDirectedEdge(g.get(0), g.get(3));

        assertTrue(g.hasEdge(g.get(0), g.get(1)));
        assertTrue(g.hasEdge(g.get(0), g.get(2)));
        assertTrue(g.hasEdge(g.get(0), g.get(3)));
        assertFalse(g.hasEdge(g.get(1), g.get(0)));
        assertFalse(g.hasEdge(g.get(2), g.get(0)));
        assertFalse(g.hasEdge(g.get(3), g.get(0)));
        assertFalse(g.hasEdge(g.get(1), g.get(2)));
        assertFalse(g.hasEdge(g.get(1), g.get(3)));
        assertFalse(g.hasEdge(g.get(2), g.get(1)));
        assertFalse(g.hasEdge(g.get(2), g.get(3)));
        assertFalse(g.hasEdge(g.get(3), g.get(1)));
        assertFalse(g.hasEdge(g.get(3), g.get(2)));
    }

}
