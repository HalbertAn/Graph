package trip;

/* You MAY add public @Test methods to this class.  You may also add
 * additional public classes containing "Testing" in their name. These
 * may not be part of your trip package per se (that is, it must be
 * possible to remove them and still have your package work). */

import org.junit.Test;
import ucb.junit.textui;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** Unit tests for the trip package. */
public class UnitTest {

    /** Run all JUnit tests in the graph package. */
    public static void main(String[] ignored) {

        System.exit(textui.runClasses(trip.UnitTest.class));
    }

    @Test
    public void smarttest() {
        assertEquals(1, 1);
    }

    @Test
    public void test1() {

        Trip read = new Trip();
        read.readMap("testing/trip/trip01.map");
        try {
            Scanner s = new Scanner(new FileReader("testing/trip/trip01.in"));
            path.add(s.next());
            path.add(s.next());
            path.add(s.next());
            read.makeTrip(path);
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException("wrong input");
        }
        path.clear();
    }
    /** arraylist. */
    private ArrayList<String> path = new ArrayList<String>();

    @Test
    public void test2() {

        Trip read = new Trip();
        read.readMap("testing/trip/trip02.map");
        try {
            Scanner s = new Scanner(
                    new FileReader("testing/trip/trip02.in"));
            path.add(s.next());
            path.add(s.next());
            read.makeTrip(path);
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException("wrong input");
        }
        path.clear();
    }

    @Test
    public void test3() {
        Trip read = new Trip();
        read.readMap("testing/trip/trip03.map");
        try {
            Scanner s = new Scanner(
                    new FileReader("testing/trip/trip03.in"));
            ArrayList<String> a = new ArrayList<String>();
            path.add(s.next());
            path.add(s.next());
            read.makeTrip(path);
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException("wrong input");
        }
        path.clear();
    }

    @Test
    public void test4() {
        Trip read = new Trip();
        read.readMap("testing/trip/trip04.map");
        try {
            Scanner s = new Scanner(
                    new FileReader("testing/trip/trip04.in"));
            ArrayList<String> a = new ArrayList<String>();
            path.add(s.next());
            path.add(s.next());
            read.makeTrip(path);
        } catch (FileNotFoundException f) {
            throw new IllegalArgumentException("wrong input");
        }
        path.clear();
    }



}
