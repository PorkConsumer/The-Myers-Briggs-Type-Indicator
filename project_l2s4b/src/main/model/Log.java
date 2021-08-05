package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a profile having a name and the owner's test results
public class Log implements Writable {

    private List<Result> data;  // list of results

    // EFFECTS: create an empty Log
    public Log() {
        data = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: Result r is added to the Log
    public void insert(Result r) {
        data.add(r);
    }

    // MODIFIES: this
    // EFFECTS: Result with associated index is removed from the Log, returns confirmation if successful
    public String remove(int index) {
        if (index >= 0 && index < data.size()) {
            data.remove(index);
            return ("Deletion completed");
        }
        return ("Such an index does not exist");
    }

    // EFFECTS: returns true if Result res is in the Log, false otherwise
    public boolean contains(Result res) {
        return data.contains(res);
    }

    // EFFECTS: returns true if the log is empty, false otherwise
    public boolean checkEmpty() {
        return data.isEmpty();
    }

    // EFFECTS: returns an unmodifiable list of results in this log
    public List<Result> getResults() {
        return Collections.unmodifiableList(data);
    }

    // EFFECTS: returns all the results in the log, with associated name and indexes
    public String print() {
        int num = 0;
        String print = "";
        for (Result r : data) {
            print += (num + ") " + r.getName() + " --- " + r.getLabel() + "\n");
            num++;
        }
        return print;
    }

    // EFFECTS: returns the results in the log with index, returns indication of failure if index is invalid
    public String find(int index) {
        for (Result r : data) {
            if (data.indexOf(r) == index) {
                return (r.getDescription());
            }
        }
        return ("Such an index does not exist");
    }

    // Citation: code obtained from JsonSerializtionDemo
    //           URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializtionDemo.git
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("results", resultsToJson());
        return json;
    }

    // EFFECTS: returns results in this log as a JSON array
    private JSONArray resultsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Result r : data) {
            jsonArray.put(r.toJson());
        }
        return jsonArray;
    }
}
