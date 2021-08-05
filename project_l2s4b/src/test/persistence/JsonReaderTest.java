package persistence;

import model.Log;
import model.Result;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Log log = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLog.json");
        try {
            Log log = reader.read();
            assertTrue(log.checkEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralLog() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralLog.json");
        try {
            Log log = reader.read();
            List<Result> results = log.getResults();
            assertEquals(2, results.size());
            checkResult("Helen", "istj", results.get(0));
            checkResult("Technoblade", "intj", results.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
