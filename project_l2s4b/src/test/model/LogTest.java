package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    private Log testLog;
    private Result testResOne = new Result("Helen", "istj");
    private Result testResTwo = new Result("Technoblade", "intj");

    @BeforeEach
    void runBefore() {
        testLog = new Log();
    }

    @Test
    void testInsertOne() {
        testLog.insert(testResOne);
        assertTrue(testLog.contains(testResOne));
        assertFalse(testLog.contains(testResTwo));
    }

    @Test
    void testInsertFew() {
        testLog.insert(testResOne);
        testLog.insert(testResTwo);
        assertTrue(testLog.contains(testResOne));
        assertTrue(testLog.contains(testResTwo));
    }

    @Test
    void testRemoveSuccess() {
        testLog.insert(testResOne);
        testLog.insert(testResTwo);
        assertEquals("Deletion completed", testLog.remove(0));
        testLog.remove(0);
        assertFalse(testLog.contains(testResOne));
    }

    @Test
    void testRemoveFailOutBounds() {
        testLog.insert(testResOne);
        assertEquals("Such an index does not exist", testLog.remove(3));
        assertTrue(testLog.contains(testResOne));
    }

    @Test
    void testRemoveFailNeg() {
        testLog.insert(testResOne);
        assertEquals("Such an index does not exist", testLog.remove(-1));
        assertTrue(testLog.contains(testResOne));
    }

    @Test
    void testCheckEmpty() {
        testLog.insert(testResOne);
        assertFalse(testLog.checkEmpty());
        testLog.remove(0);
        assertTrue(testLog.checkEmpty());
    }

    @Test
    void testPrintSomething() {
        testLog.insert(testResOne);
        testLog.insert(testResTwo);
        assertEquals("0) Helen --- istj\n1) Technoblade --- intj\n", testLog.print());
    }

    @Test
    void testPrintNothing() {
        assertEquals("", testLog.print());
    }

    @Test
    void testFindSuccess() {
        testLog.insert(testResOne);
        assertEquals("ISTJ - INSPECTOR\n"
                + "Thoughtful, pensive, responsible.\n"
                + "You are trustworthy, but you never take things as they are, always analyzing the incoming "
                + "information.\n"
                + "You are not interested in long-term communication and prefer official communication only "
                + "during companionship.\n"
                + "You are aimed at the final result.\n" + "\n"
                + "You like strictness and order, and very often you are pedantic.\n"
                + "You don't live in your dreams, only in the \"here and now.\"", testLog.find(0));
    }

    @Test
    void testFindFailNeg() {
        testLog.insert(testResOne);
        assertEquals("Such an index does not exist", testLog.find(-1));
    }

    @Test
    void testFindFailOutBounds() {
        testLog.insert(testResOne);
        assertEquals("Such an index does not exist", testLog.find(3));
    }

    @Test
    void testGetResults() {
        testLog.insert(testResOne);
        testLog.insert(testResTwo);
        List <Result> res = testLog.getResults();
        assertEquals("Helen", res.get(0).getName());
        assertEquals("Technoblade", res.get(1).getName());
    }

    @Test
    void testToJson() {
        testLog.insert(testResOne);
        testLog.insert(testResTwo);

        JSONObject json = testLog.toJson();
        JSONArray jsonArray = json.getJSONArray("results");

        assertEquals("{\"name\":\"Helen\",\"label\":\"istj\"}", jsonArray.get(0).toString());
        assertEquals("{\"name\":\"Technoblade\",\"label\":\"intj\"}", jsonArray.get(1).toString());
    }
}