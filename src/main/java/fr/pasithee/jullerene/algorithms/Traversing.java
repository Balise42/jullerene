package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Edge;
import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.model.Vertex;

import java.util.Deque;
import java.util.LinkedList;

import static fr.pasithee.jullerene.model.Constants.NOT_VISITED;

public abstract class Traversing {
    protected final Graph graph;

    public Traversing(Graph graph) {
        this.graph = graph;
    }

    protected abstract int[] step(int[] visitOrder);

    public int[] step() {
        int[] visitOrder = new int[graph.getNbVertices()];
        for(int i = 0; i< graph.getNbVertices(); i++) {
            visitOrder[i] = NOT_VISITED;
        }
        return step(visitOrder);
    }

}
