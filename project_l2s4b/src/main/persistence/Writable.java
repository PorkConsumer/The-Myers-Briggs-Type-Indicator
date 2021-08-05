package persistence;

import org.json.JSONObject;

// Citation: code obtained from JsonSerializtionDemo
//           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializtionDemo.git
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
