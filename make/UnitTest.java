package make;

/* You MAY add public @Test methods to this class.  You may also add
 * additional public classes containing "UnitTest" in their name. These
 * may not be part of your make package per se (that is, it must be
 * possible to remove them and still have your package work). */

import org.junit.Test;
import ucb.junit.textui;
import static org.junit.Assert.*;
import java.util.HashMap;

/** Unit tests for the make package. */
public class UnitTest {

    /** Run all JUnit tests in the make package. */
    public static void main(String[] ignored) {
        System.exit(textui.runClasses(make.UnitTest.class));
    }

    @Test
    public void dummyTest1() {
        assertEquals(1, 1);
    }
    /**
    @Test
    public void maketest1() {
        Maker make = new Maker();
        make.readFileAges("testing/make/make01.dir");
        map.put("foo", 90);
        map.put("foo.y", 50);
        map.put("foo.h", 10);
        assertEquals("wrong foo",
                map.get("foo"), make.getInitialAge("foo"));
        assertEquals("wrong foo.y", map.get("foo.y"),
                make.getInitialAge("foo.y"));
        assertEquals("wrong foo.h", map.get("foo.h"),
                make.getInitialAge("foo.h"));
        map.clear();

    }

    @Test
    public void maketest2() {
        Maker make = new Maker();
        make.readFileAges("testing/make/make02.dir");
        map.put("foo", 90);
        map.put("foo.y", 50);
        map.put("foo.h", 10);
        assertEquals("wrong foo",
                map.get("foo"), make.getInitialAge("foo"));
        assertEquals("wrong foo.y", map.get("foo.y"),
                make.getInitialAge("foo.y"));
        assertEquals("wrong foo.h", map.get("foo.h"),
                make.getInitialAge("foo.h"));
        map.clear();

    }

    @Test
    public void maketest3() {
        Maker make = new Maker();
        make.readFileAges("testing/make/make03.dir");
        map.put("foo", 90);
        map.put("foo.y", 50);
        map.put("foo.h", 10);
        assertEquals("wrong foo",
                map.get("foo"), make.getInitialAge("foo"));
        assertEquals("wrong foo.y", map.get("foo.y"),
                make.getInitialAge("foo.y"));
        assertEquals("wrong foo.h", map.get("foo.h"),
                make.getInitialAge("foo.h"));
        map.clear();

    }
    @Test
    public void maketest4() {
        Maker make = new Maker();
        make.readFileAges("testing/make/make04.dir");
        map.put("foo", 90);
        map.put("foo.y", 50);
        map.put("foo.h", 10);
        assertEquals("wrong foo",
                map.get("foo"), make.getInitialAge("foo"));
        assertEquals("wrong foo.y", map.get("foo.y"),
                make.getInitialAge("foo.y"));
        assertEquals("wrong foo.h", map.get("foo.h"),
                make.getInitialAge("foo.h"));
        map.clear();

    }


    private  HashMap<String, Integer> map = new HashMap<String, Integer>();
    */

}
