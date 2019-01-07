package graph;

import org.junit.Test;
import static org.junit.Assert.*;

/** Unit tests for the Graph class.
 *  @author alberthan
 */
public class GraphTest {
    @Test
    public void emptyGraph() {
        DirectedGraph g = new DirectedGraph();
        assertEquals("Initial graph has vertices", 0, g.vertexSize());
        assertEquals("Initial graph has edges", 0, g.edgeSize());
    }

    @Test
    public void directedgraphTest() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 4, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 3, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 3, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
    }
    @Test
    public void undirectedgraphTest() {
        UndirectedGraph dgraph1 = new UndirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 2, dgraph1.inDegree(1));
        assertEquals("wrong edge size", 4, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(1);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 3, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 3, dgraph1.maxVertex());
    }

    @Test
    public void directedgraphTest2() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(2, 3);
        dgraph1.add(2, 2);
        dgraph1.add(3, 4);
        assertEquals("wrong outdegree", 1, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 2, dgraph1.inDegree(2));
        assertFalse("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        assertEquals("wrong successor", 2, a);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        assertEquals("wrong predecessor", 3, c);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 3, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 3, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
    }

    @Test
    public void directedgraphTest3() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        dgraph1.add(4, 5);
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 5, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 5, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 6, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
    }

    @Test
    public void directedgraphTest4() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        dgraph1.add(5, 6);
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 5, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 5, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 6, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
    }

    @Test
    public void directedgraphTest5() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        dgraph1.add(3, 4);
        dgraph1.add(1, 4);
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 5, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 5, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 6, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
    }

    @Test
    public void directedgraphTest6() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        dgraph1.add(3, 5);
        assertEquals("wrong outdegree", 2, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 5, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 4, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 5, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
    }

    @Test
    public void directedgraphTest7() {
        DirectedGraph dgraph1 = new DirectedGraph();
        dgraph1.add();
        assertEquals("wrong vertices size", 1, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 1, dgraph1.maxVertex());
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add();
        dgraph1.add(1, 2);
        dgraph1.add(1, 3);
        dgraph1.add(2, 4);
        dgraph1.add(3, 4);
        dgraph1.add(1, 5);
        assertEquals("wrong outdegree", 3, dgraph1.outDegree(1));
        assertEquals("wrong indegree", 1, dgraph1.inDegree(2));
        assertEquals("wrong edge size", 5, dgraph1.edgeSize());
        assertTrue("wrong edgecontaining", dgraph1.contains(1, 3));
        Iteration<Integer> first = dgraph1.successors(1);
        int a = first.next();
        int b = first.next();
        assertEquals("wrong successor", 2, a);
        assertEquals("wrong successor", 3, b);
        Iteration<Integer> second = dgraph1.predecessors(4);
        int c = second.next();
        int d = second.next();
        assertEquals("wrong predecessor", 2, c);
        assertEquals("wrong predecessor", 3, d);
        dgraph1.remove(4);
        assertFalse("wrong vertice remove", dgraph1.contains(4));
        assertFalse("wrong vertice remove", dgraph1.contains(3, 4));
        assertFalse("wrong vertice remove", dgraph1.contains(2, 4));
        assertEquals("wrong vertices size", 4, dgraph1.vertexSize());
        assertEquals("wrong max vertice", 5, dgraph1.maxVertex());
        dgraph1.add(1, 1);
        assertEquals("wrong indegree", 1, dgraph1.inDegree(1));
        assertEquals("wrong outdegree", 4, dgraph1.outDegree(1));
    }

}
