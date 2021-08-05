package persistence;

import model.Result;
import model.Log;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads log from JSON data stored in file
// Citation: code obtained from JsonSerializtionDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializtionDemo.git
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads log from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Log read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses log from JSON object and returns it
    private Log parseLog(JSONObject jsonObject) {
        Log log = new Log();
        addResults(log, jsonObject);
        return log;
    }

    // MODIFIES: log
    // EFFECTS: parses results from JSON object and adds them to log
    private void addResults(Log log, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (Object json : jsonArray) {
            JSONObject nextResult = (JSONObject) json;
            addResult(log, nextResult);
        }
    }

    // MODIFIES: log
    // EFFECTS: parses result from JSON object and adds it to log
    private void addResult(Log log, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String label = jsonObject.getString("label");
        Result result = new Result(name, label);
        log.insert(result);
    }
}
