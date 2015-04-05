package fr.pasithee.jullerene.model;

import java.util.Objects;

public class Vertex {
    private int label;

    public Vertex(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
