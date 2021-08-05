package persistence;

import model.Log;
import model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    private Log log;

    @BeforeEach
    void runBefore() {
        log = new Log();
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLog() {
        try {
            JsonWriter writer = new JsonWriter("./data/testReaderEmptyLog.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testReaderEmptyLog.json");
            log = reader.read();
            assertTrue(log.checkEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralLog() {
        try {
            log.insert(new Result("Helen", "istj"));
            log.insert(new Result("Technoblade", "intj"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralLog.json");
            writer.open();
            writer.write(log);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralLog.json");
            log = reader.read();
            List<Result> results = log.getResults();
            assertEquals(2, results.size());
            checkResult("Helen", "istj", results.get(0));
            checkResult("Technoblade", "intj", results.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
