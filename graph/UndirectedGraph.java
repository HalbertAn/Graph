package graph;

/* See restrictions in Graph.java. */

import java.util.ArrayList;

/** Represents an undirected graph.  Out edges and in edges are not
 *  distinguished.  Likewise for successors and predecessors.
 *
 *  @author alberthan
 */
public class UndirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public int inDegree(int v) {
        int result = 0;
        for (int[] a : edges()) {
            if (a[0] == v || a[1] == v) {
                result++;
            }
        }
        return result;
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        ArrayList<Integer> prev = new ArrayList<>();
        for (int[] a : edges()) {
            if (a[0] == v) {
                prev.add(a[1]);
            } else if (a[1] == v) {
                prev.add(a[0]);
            }
        }
        return Iteration.iteration(prev.iterator());
    }

}
