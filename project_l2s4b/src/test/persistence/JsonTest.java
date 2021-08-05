package persistence;

import model.Result;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkResult(String name, String label, Result res) {
        assertEquals(name, res.getName());
        assertEquals(label, res.getLabel());
    }
}
