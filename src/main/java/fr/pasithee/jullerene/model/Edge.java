package fr.pasithee.jullerene.model;

import java.util.Objects;

/** Edge of a {@link Graph}*/
public class Edge {
    /** first endpont of the edge */
    private final Vertex v1;
    /** second endpoint of the edge */
    private final Vertex v2;

    /** Constructor
     * @param v1 first endpoint of the edge
     * @param v2 second endpoint of the edge */
    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(v1, edge.v1) &&
                Objects.equals(v2, edge.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }
}
