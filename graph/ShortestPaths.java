package graph;

/* See restrictions in Graph.java. */

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/** The shortest paths through an edge-weighted graph.
 *  By overrriding methods getWeight, setWeight, getPredecessor, and
 *  setPredecessor, the client can determine how to represent the weighting
 *  and the search results.  By overriding estimatedDistance, clients
 *  can search for paths to specific destinations using A* search.
 *  @author alberthan with pseudocode/ideas from P. N. Hilfinger's Lecture code
 */
public abstract class ShortestPaths {

    /**
     * The shortest paths in G from SOURCE.
     */
    public ShortestPaths(Graph G, int source) {
        this(G, source, 0);
    }

    /**
     * A shortest path in G from SOURCE to DEST.
     */
    public ShortestPaths(Graph G, int source, int dest) {
        _G = G;
        _source = source;
        _dest = dest;
        fringetree = new TreeSet<>(new Pathcompar());
    }

    /**
     * Initialize the shortest paths.  Must be called before using
     * getWeight, getPredecessor, and pathTo.
     */
    public void setPaths() {
        int source = getSource();
        fringetree.add(source);
        for (int x : _G.vertices()) {
            setWeight(x, Double.POSITIVE_INFINITY);
        }
        setWeight(_source, 0);
        while (!fringetree.isEmpty()) {
            int start = fringetree.pollFirst();
            if (start == _dest) {
                break;
            } else {
                for (int successor : _G.successors(start)) {
                    if (getWeight(successor) > getWeight(start)
                            + getWeight(start, successor)) {
                        if (fringetree.contains(successor)) {
                            fringetree.remove(successor);
                        }
                        setWeight(successor, getWeight(start)
                                + getWeight(start, successor));
                        setPredecessor(successor, start);
                        fringetree.add(successor);
                    }
                }
            }
        }
    }

    /**
     * Returns the starting vertex.
     */
    public int getSource() {
        return _source;
    }

    /**
     * Returns the target vertex, or 0 if there is none.
     */
    public int getDest() {
        return _dest;
    }

    /**
     * Returns the current weight of vertex V in the graph.  If V is
     * not in the graph, returns positive infinity.
     */
    public abstract double getWeight(int v);

    /**
     * Set getWeight(V) to W. Assumes V is in the graph.
     */
    protected abstract void setWeight(int v, double w);

    /**
     * Returns the current predecessor vertex of vertex V in the graph, or 0 if
     * V is not in the graph or has no predecessor.
     */
    public abstract int getPredecessor(int v);

    /**
     * Set getPredecessor(V) to U.
     */
    protected abstract void setPredecessor(int v, int u);

    /**
     * Returns an estimated heuristic weight of the shortest path from vertex
     * V to the destination vertex (if any).  This is assumed to be less
     * than the actual weight, and is 0 by default.
     */
    protected double estimatedDistance(int v) {
        return 0.0;
    }

    /**
     * Returns the current weight of edge (U, V) in the graph.  If (U, V) is
     * not in the graph, returns positive infinity.
     */
    protected abstract double getWeight(int u, int v);

    /**
     * Returns a list of vertices starting at _source and ending
     * at V that represents a shortest path to V.  Invalid if there is a
     * destination vertex other than V.
     */
    public List<Integer> pathTo(int v) {
        while (getPredecessor(v) != 0) {
            paths.add(v);
            v = getPredecessor(v);
        }
        Collections.reverse(paths);
        return paths;
    }

    /**
     * Returns a list of vertices starting at the source and ending at the
     * destination vertex. Invalid if the destination is not specified.
     */
    public List<Integer> pathTo() {
        return pathTo(getDest());
    }

    /**
     * Comparator treeset.
     */
    private class Pathcompar implements Comparator<Integer> {
        @Override
        public int compare(Integer u, Integer v) {
            double patha = getWeight(u) + estimatedDistance(u);
            double pathb = getWeight(v) + estimatedDistance(v);
            if (patha > pathb) {
                return 1;
            }
            if (patha < pathb) {
                return -1;
            }
            return u - v;
        }
    }


    /** The graph being searched. */
    protected final Graph _G;
    /** The starting vertex. */
    private final int _source;
    /** The target vertex. */
    private final int _dest;
    /** fringe in a treeset. */
    private TreeSet<Integer> fringetree;
    /** a list of paths. */
    private ArrayList<Integer> paths = new ArrayList<>();
}
