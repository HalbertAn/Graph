package graph;

/* See restrictions in Graph.java. */

import java.util.ArrayList;

/** Represents a general unlabeled directed graph whose vertices are denoted by
 *  positive integers. Graphs may have self edges.
 *
 *  @author alberthan
 */
public class DirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public int inDegree(int v) {
        int result = 0;
        for (int[] a : edges()) {
            if (a[1] == v) {
                result++;
            }
        }
        return result;
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        ArrayList<Integer> prev = new ArrayList<>();
        for (int[] a : edges()) {
            if (a[1] == v) {
                prev.add(a[0]);
            }
        }
        return Iteration.iteration(prev.iterator());
    }

}
