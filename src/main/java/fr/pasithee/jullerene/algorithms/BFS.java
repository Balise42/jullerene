package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Edge;
import fr.pasithee.jullerene.model.Graph;
import fr.pasithee.jullerene.model.Vertex;

import java.util.Deque;
import java.util.LinkedList;

import static fr.pasithee.jullerene.model.Constants.NOT_VISITED;

public class BFS extends Traversing {
    public BFS(Graph graph) {
        super(graph);
    }

    @Override
    protected int[] step(int[] visitOrder) {
        Deque<Vertex> queue = new LinkedList<>();
        int lastVisited = -1;
        for(int i = 0; i<visitOrder.length; i++) {
            if(visitOrder[i] == NOT_VISITED && queue.isEmpty()) {
                queue.add(graph.get(i));
            } else if (visitOrder[i] > lastVisited) {
                lastVisited = lastVisited + 1;
            }
        }
        if(!queue.isEmpty()) {
            Vertex start = queue.peek();
            visitOrder[start.getLabel()] = lastVisited + 1;
            lastVisited++;
        }
        while(!queue.isEmpty()) {
            Vertex u = queue.pop();
            for(Edge e : graph.getAdjacentEdges(u)) {
                Vertex v = e.getV2();
                if(visitOrder[v.getLabel()] == NOT_VISITED) {
                    queue.addLast(v);
                    visitOrder[v.getLabel()] = lastVisited + 1;
                    lastVisited++;
                }
            }
        }
        return visitOrder;
    }
}