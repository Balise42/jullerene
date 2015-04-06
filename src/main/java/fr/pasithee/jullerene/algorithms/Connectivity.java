package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Constants;
import fr.pasithee.jullerene.model.Graph;

/** Connectivity algorithms for {@link Graph}*/
public class Connectivity {
    /** Graph to which the algorithms can be applied. */
    private final Graph g;
    /** Traversal algorithm for the connectivity algorithm */
    private final Traversal traversal;

    /** Constructor.
     * @param g graph to which the algorithms can be applied
     * @param traversal traversal algorithm used by connectivity algorithms */
    public Connectivity(Graph g, Traversal traversal) {
        this.g = g;
        this.traversal = traversal;
    }

    /** Checks connectivity of the graph
     * @return true if the graph is connected, false otherwise */
    public boolean isConnected() {
        int[] visitOrder = traversal.step();
        for(int i = 0; i<g.getNbVertices(); i++) {
            if(visitOrder[i] == Constants.NOT_VISITED) {
                return false;
            }
        }
        return true;
    }
}
