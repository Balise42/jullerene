package fr.pasithee.jullerene;

import fr.pasithee.jullerene.model.EdgeListsGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*public class GraphTest {
    @Test
    public void hasEdgeWithUndirectedEdgesShouldReturnCorrectValues() {
        EdgeListsGraph g = new EdgeListsGraph(4);
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
        EdgeListsGraph g = new EdgeListsGraph(4);
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

    @Test
    public void insertDirectedEdgeWithVertexNumberShouldWork() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(1, 2);
        EdgeListsGraph expected = new EdgeListsGraph(3);
        expected.addDirectedEdge(expected.get(0), expected.get(1));
        expected.addDirectedEdge(expected.get(1), expected.get(2));
        assertEquals(expected, g);
    }

    @Test
    public void insertUndirectedEdgeWithVertexNumberShouldWork() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(1, 2);
        EdgeListsGraph expected = new EdgeListsGraph(3);
        expected.addUndirectedEdge(expected.get(0), expected.get(1));
        expected.addUndirectedEdge(expected.get(1), expected.get(2));
        assertEquals(expected, g);
    }

    @Test
    public void getVertexWithVertexNumberShouldWork() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        Vertex result = g.get(1);
        assertEquals(1, result.getLabel());
    }

    @Test(expected=IllegalArgumentException.class)
    public void getVertexWithInvalidValueShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.get(4);
    }

    @Test(expected=IllegalArgumentException.class)
    public void addDirectedEdgeWithInvalidVertexShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        Vertex v = new Vertex(4);
        g.addDirectedEdge(v, v);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopUndirectedVertexEdgeShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addUndirectedEdge(g.get(0), g.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopDirectedVertexEdgeShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addDirectedEdge(g.get(0), g.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopUndirectedIntEdgeShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addUndirectedEdge(0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addLoopDirectedIntEdgeShouldThrow() {
        EdgeListsGraph g = new EdgeListsGraph(3);
        g.addDirectedEdge(0,0);
    }*/

    public class GraphTest {
        @Test
        public void doNothing() {
        }
    }
