package fr.pasithee.jullerene.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/** Edge of a {@link Graph}*/
public class Edge<T> {

    /** first endpoint of the edge */
    private final T n1;
    /** second endpoint of the edge */
    private final T n2;

    /** Constructor
     * @param n1 first endpoint of the edge
     * @param n2 second endpoint of the edge */
    public Edge(T n1, T n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Nodes cannot be null");
        }
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(n1, edge.n1) &&
                Objects.equals(n2, edge.n2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2);
    }

    public boolean hasEndPoint(T node) {
        return hasFirstEndpoint(node) || hasSecondEndpoint(node);
    }

    public boolean hasFirstEndpoint(T node) {
        return n1.equals(node);
    }

    public boolean hasSecondEndpoint(T node) {
        return n2.equals(node);
    }

    public boolean isBetween(T node1, T node2, boolean directed) {
        return isBetween(node1, node2) || (!directed && isBetween(node2, node1));
    }

    private boolean isBetween(T node1, T node2) {
        return n1.equals(node1) && n2.equals(node2);
    }

    public T getOtherEnd(T node) {
        if (hasFirstEndpoint(node)) {
            return n2;
        }
        if (hasSecondEndpoint(node)) {
            return n1;
        }
        throw new IllegalArgumentException("The provided node is not in the edge");
    }

    public List<? extends T> getVertices() {
        List<T> c = new ArrayList<T>();
        c.add(n1);
        c.add(n2);
        return c;
    }
}
