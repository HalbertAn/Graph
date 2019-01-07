package graph;
import org.junit.Test;
import ucb.junit.textui;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



/* You MAY add public @Test methods to this class.  You may also add
 * additional public classes containing "Testing" in their name. These
 * may not be part of your graph package per se (that is, it must be
 * possible to remove them and still have your package work). */

/** Unit tests for the graph package.  This class serves to dispatch
 *  other test classes, which are listed in the argument to runClasses.
 *  @author alberthan
 */
public class UnitTest {

    /**
     * Run all JUnit tests in the graph package.
     */
    public static void main(String[] ignored) {
        System.exit(textui.runClasses(graph.GraphTest.class));
    }

     /** Test for Traversal functions. */
    private ArrayList<Integer> correct = new ArrayList<>();
    private ArrayList<Integer> postheck = new ArrayList<>();
    private ArrayList<Integer> cur = new ArrayList<>();
    private ArrayList<Integer> visitedvertices = new ArrayList<>();
    private ArrayList<Integer> postvisited = new ArrayList<>();
    private ArrayList<Integer> visitednode =  new ArrayList<>();
    private ArrayList<Integer> postvisitnode =  new ArrayList<>();

    class Breadth extends BreadthFirstTraversal {
        private Breadth(Graph g) {
            super(g);
        }
        @Override
        protected boolean visit(int v) {
            correct.add(v);
            return super.visit(v);
        }
    }

    class Depth extends DepthFirstTraversal {
        private Depth(Graph g) {
            super(g);
        }
        @Override
        protected boolean postVisit(int v) {
            postheck.add(v);
            return super.postVisit(v);
        }
        @Override
        protected boolean visit(int v) {
            cur.add(v);
            return super.visit(v);
        }
    }

    private class BreadthFirstTraversalTest extends BreadthFirstTraversal {

        BreadthFirstTraversalTest(Graph g) {
            super(g);
        }
        @Override
        protected boolean postVisit(int v) {
            postvisitnode.add(v);
            return true;
        }
        @Override
        protected boolean visit(int v) {
            visitednode.add(v);
            return true;
        }
    }

    private class DepthFirstTraversalTest extends DepthFirstTraversal {
        DepthFirstTraversalTest(Graph G) {
            super(G);
        }

        @Override
        protected boolean visit(int v) {
            visitedvertices.add(v);
            return true;
        }
        @Override
        protected boolean postVisit(int v) {
            postvisited.add(v);
            return true;
        }
    }

    @Test
    public void testTraversal3() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(1, 5);
        BreadthFirstTraversalTest current =
                new BreadthFirstTraversalTest(graph);
        ArrayList<Integer> results1 = new ArrayList<Integer>();
        ArrayList<Integer> results2 = new ArrayList<Integer>();
        ArrayList<Integer> results3 = new ArrayList<Integer>();
        ArrayList<Integer> results4 = new ArrayList<Integer>();
        results1.add(1);
        results1.add(2);
        results1.add(3);
        results1.add(4);
        results2.add(1);
        results2.add(2);
        results2.add(3);
        results2.add(4);
        results3.add(1);
        results3.add(2);
        results3.add(3);
        results3.add(4);
        results4.add(1);
        results4.add(2);
        results4.add(3);
        results4.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = visitednode;
        assertTrue(curr.equals(results1)
                || curr.equals(results2) || curr.equals(results3)
                || curr.equals(results4));
    }

    @Test
    public void testTraversalfirst() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(3, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = visitedvertices;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }

    @Test
    public void testTraversalsecond() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }

    @Test
    public void traversalTest() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(4, 3);
        graph.add(5, 3);
        graph.add(5, 6);
        Breadth zero = new Breadth(graph);
        List<Integer> a = asList(1, 2, 3, 4, 5, 6);
        zero.traverse(1);
        assertEquals(a, correct);
        Depth one = new Depth(graph);
        List<Integer> b = asList(1, 5, 2, 6, 3, 3);
        List<Integer> c = asList(1, 3, 6, 5, 2, 4);
        one.traverse(1);
        assertTrue(cur.equals(b)
                || cur.equals(c));

        DirectedGraph graph2 = new DirectedGraph();
        graph2.add();
        graph2.add();
        graph2.add();
        graph2.add();
        graph2.add();
        graph2.add(5, 3);
        graph2.add(4, 1);
        graph2.add(3, 2);
        graph2.add(1, 5);
        Depth two = new Depth(graph2);
        List<Integer> otf = asList(1, 2, 3, 4, 5);
        List<Integer> fff = asList(1, 2, 3, 4, 5);
        List<Integer> wtf1 = asList(1, 2, 3, 4, 5);
        List<Integer> wtf2 = asList(1, 2, 3, 4, 5);
        two.traverse(5);
        assertTrue(otf.equals(cur) || fff.equals(cur));
        assertTrue(postheck.equals(wtf1)
                || postheck.equals(wtf2));

    }
    @Test
    public void testTraversalsecond2() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 2);
        graph.add(2, 1);
        graph.add(4, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond3() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(4, 1);
        graph.add(4, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond4() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(2, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond5() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(3, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond6() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(1, 2);
        graph.add(4, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond7() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 2);
        graph.add(3, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond8() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(3, 2);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
    @Test
    public void testTraversalsecond9() {
        DirectedGraph graph = new DirectedGraph();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add();
        graph.add(1, 3);
        graph.add(3, 1);
        graph.add(4, 1);
        graph.add(1, 5);
        DepthFirstTraversalTest current = new DepthFirstTraversalTest(graph);
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        result1.add(1);
        result1.add(2);
        result1.add(3);
        result1.add(4);
        result2.add(1);
        result2.add(2);
        result2.add(3);
        result2.add(4);
        current.traverse(5);
        ArrayList<Integer> curr = postvisited;
        assertTrue(curr.equals(result1)
                || curr.equals(result2));
    }
}


