package fr.pasithee.jullerene.algorithms;

import fr.pasithee.jullerene.model.Edge;
import fr.pasithee.jullerene.model.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import static fr.pasithee.jullerene.model.Constants.NOT_VISITED;

public class BFS<T> extends Traversal<T> {

    public BFS(Graph<T> graph) {
        super(graph);
    }

    @Override
    protected Map<T, Integer> step(Map<T, Integer> visitOrder) {
        Deque<T> queue = initQueue(visitOrder);
        while(!queue.isEmpty()) {
            T u = queue.pop();
            for(Edge<T> e : graph.getOutEdges(u)) {
                T v = e.getOtherEnd(u);
                if(visitOrder.get(v) == NOT_VISITED) {
                    queue.addLast(v);
                    visitOrder.put(v,lastVisited + 1);
                    lastVisited++;
                }
            }
        }
        return visitOrder;
    }

    private Deque<T> initQueue(Map<T, Integer> visitOrder) {
        Deque<T> queue = new LinkedList<>();
        for(Map.Entry<T, Integer> kv : visitOrder.entrySet()) {
            if(kv.getValue()== NOT_VISITED && queue.isEmpty()) {
                queue.add(kv.getKey());
            } else if (kv.getValue() > lastVisited) {
                lastVisited = kv.getValue();
            }
        }
        giveFirstVertexVisitOrder(queue, visitOrder);
        return queue;
    }

    private void giveFirstVertexVisitOrder(Deque<T> queue, Map<T, Integer> visitOrder) {
        if(!queue.isEmpty()) {
            T start = queue.peek();
            visitOrder.put(start, lastVisited + 1);
            lastVisited++;
        }
    }
}
