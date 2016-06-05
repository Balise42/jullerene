package fr.pasithee.jullerene;

import fr.pasithee.jullerene.algorithms.Connectivity;
import fr.pasithee.jullerene.algorithms.Traversal;
import fr.pasithee.jullerene.model.EdgeListsGraph;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ConnectivityTest {
    @Mock
    private Traversal traversal;
    @Mock
    private EdgeListsGraph graph;
    @InjectMocks
    private Connectivity connectivity;

    @Before
    public void setup() {
        initMocks(this);
    }

    /*@Test
    public void isConnectedWithConnectedArrayShouldReturnTrue() {
        int[] visited = new int[3];
        visited[0] = 0;
        visited[1] = 1;
        visited[2] = 2;
        when(traversal.step()).thenReturn(visited);
        when(graph.getNbVertices()).thenReturn(3);
        assertTrue(connectivity.isConnected());
    }

    @Test
    public void isConnectedWithDisconnectedArrayShouldReturnFalse() {
        int[] visited = new int[3];
        visited[0] = 0;
        visited[1] = -1;
        visited[2] = 2;
        when(traversal.step()).thenReturn(visited);
        when(graph.getNbVertices()).thenReturn(3);
        assertFalse(connectivity.isConnected());
    }*/
}
