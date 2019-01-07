package graph;

/* See restrictions in Graph.java. */
import java.util.ArrayList;
import java.util.Arrays;

/** A partial implementation of Graph containing elements common to
 *  directed and undirected graphs.
 *
 *  @author alberthan
 */
abstract class GraphObj extends Graph {
    /**
     * all the vertices.
     */
    private ArrayList<Integer> vertices;
    /**
     * all the edges.
     */
    private ArrayList<int[]> edges;

    /**
     * A new, empty Graph.
     */
    GraphObj() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public int vertexSize() {
        return vertices.size();
    }

    @Override
    public int maxVertex() {
        if (vertices.size() > 0) {
            int[] varray = new int[vertices.size()];
            int index = 0;
            for (Integer i : vertices) {
                if (index < vertices.size()) {
                    varray[index] = i;
                    index++;
                }
            }
            Arrays.sort(varray);
            return varray[varray.length - 1];
        } else {
            return 0;
        }
    }

    @Override
    public int edgeSize() {
        return edges.size();
    }

    @Override
    public abstract boolean isDirected();

    @Override
    public int outDegree(int v) {
        int result = 0;
        if (!vertices.contains(v)) {
            return 0;
        }
        if (isDirected()) {
            for (int[] a : edges) {
                if (a[0] == v) {
                    result++;
                }
            }
        } else {
            for (int[] a : edges) {
                if (a[0] == v || a[1] == v) {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public abstract int inDegree(int v);

    @Override
    public boolean contains(int u) {
        for (int a : vertices) {
            if (a == u) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int u, int v) {
        if (!contains(u) || !contains(v)) {
            return false;
        }
        for (int[] a : edges) {
            if (isDirected()) {
                if (a[0] == u && a[1] == v) {
                    return true;
                }
            } else {
                if ((a[1] == u && a[0] == v)
                        || (a[0] == u && a[1] == v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int add() {
        if (vertices.size() < maxVertex()) {
            for (int i = 1; i < maxVertex(); i++) {
                if (!vertices.contains(i)) {
                    vertices.add(i);
                    return i;
                }
            }
        }
        int next = maxVertex() + 1;
        vertices.add(next);
        return next;
    }



    @Override
    public int add(int u, int v) {
        checkMyVertex(u);
        checkMyVertex(v);
        for (int[] a : edges) {
            if (a[0] == u && a[1] == v) {
                return edgeId(u, v);
            }
        }
        int[] newedge = new int[2];
        newedge[0] = u;
        newedge[1] = v;
        edges.add(newedge);
        return edgeId(u, v);
    }

    @Override
    public void remove(int v) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == v) {
                vertices.remove(i);
            }
        }
        ArrayList<int[]> a = new ArrayList<>();
        a.addAll(edges);
        for (int i = 0; i < a.size(); i++) {
            int b = a.size() - edges.size();
            if (a.get(i)[0] == v || a.get(i)[1] == v) {
                remove(edges.get(i - b)[0], edges.get(i - b)[1]);
            }
        }
    }

    @Override
    public void remove(int u, int v) {
        ArrayList<int[]> a = new ArrayList<>();
        a.addAll(edges);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] == u && a.get(i)[1] == v) {
                edges.remove(i);
            }
        }
    }

    @Override
    public Iteration<Integer> vertices() {
        return Iteration.iteration(vertices.iterator());
    }

    @Override
    public Iteration<Integer> successors(int v) {
        ArrayList<Integer> next = new ArrayList<>();
        if (isDirected()) {
            for (int[] a : edges) {
                if (a[0] == v) {
                    next.add(a[1]);
                }
            }
        } else {
            for (int[] a : edges) {
                if (a[0] == v) {
                    next.add(a[1]);
                } else if (a[1] == v) {
                    next.add(a[0]);
                }
            }
        }
        return Iteration.iteration(next.iterator());
    }

    @Override
    public abstract Iteration<Integer> predecessors(int v);

    @Override
    public Iteration<int[]> edges() {
        return Iteration.iteration(edges.iterator());
    }

    @Override
    protected void checkMyVertex(int v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("vertex not from Graph");
        }
    }

    @Override
    protected int edgeId(int u, int v) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i)[0] == u && edges.get(i)[1] == v) {
                return i + 1;
            }
        }
        return 0;
    }
}
