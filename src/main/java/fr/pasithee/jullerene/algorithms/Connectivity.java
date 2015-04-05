package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Graph;

public class Connectivity {
    private final Graph g;
    private final Traversing traversing;

    public Connectivity(Graph g, Traversing traversing) {
        this.g = g;
        this.traversing = traversing;
    }

    public boolean isConnected() {
        int[] visitOrder = traversing.step();
        for(int i = 0; i<g.getNbVertices(); i++) {
            if(visitOrder[i] == -1) {
                return false;
            }
        }
        return true;
    }
}
