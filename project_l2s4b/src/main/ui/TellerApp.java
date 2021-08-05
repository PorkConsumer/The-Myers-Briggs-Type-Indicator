package ui;

import expection.LabelNotFoundException;
import model.Log;
import model.Result;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Personality test teller application
// Citation: reference to CPSC 210's TellerApp
public class TellerApp {
    private static final String JSON_STORE = "./data/log.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Log log;
    private Result result;
    private Scanner input;

    // EFFECTS: constructs log and runs the teller application
    public TellerApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        log = new Log();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runTeller();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTeller() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // REQUIRES: command is not null
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("n")) {
            doNewTest();
        } else if (command.equals("v")) {
            doViewLog();
        } else if (command.equals("c")) {
            doChooseResult();
        } else if (command.equals("d")) {
            doDeleteResult();
        } else if (command.equals("s")) {
            saveLog();
        } else if (command.equals("l")) {
            loadLog();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n\n***** The Myers-Briggs Type Indicator *****");
        System.out.println("\tn -> new test");
        System.out.println("\tv -> view log");
        System.out.println("\tc -> choose result");
        System.out.println("\td -> delete result");
        System.out.println("\ts -> save log to file");
        System.out.println("\tl -> load log to file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a test, if the combination made is valid, prints out the result description
    //          and add it to the log, otherwise indicate that the combination was wrong
    private void doNewTest() {
        System.out.println("What is your name?");
        String name = input.next();
        String c1 = doChoiceOne();
        String c2 = doChoiceTwo();
        String c3 = doChoiceThree();
        String c4 = doChoiceFour();
        if ((c1.equals("e") || c1.equals("i")) && (c2.equals("s") || c2.equals("n"))
                && (c3.equals("t") || c3.equals("f")) && (c4.equals("p") || c4.equals("j"))) {
            init(name, c1 + c2 + c3 + c4);
        } else {
            System.out.println("You entered a wrong combination, try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: takes in a String name and a String label to initializes results,
    //          prints its description, add it to the log
    private void init(String name, String res) {
        result = new Result(name, res);
        System.out.println("Your result is: \n");
        System.out.println(result.getDescription());
        log.insert(result);
    }

    // EFFECTS: conducts the first question and return a String of the option chosen
    private String doChoiceOne() {
        System.out.println("1. How are you going to spend your weekend?\n"
                + "\te -> I'll call my friends to all go out together.\n"
                + "\ti -> I'll switch on the \"Don't disturb\" mode on my phone and stay at home.");
        return input.next();
    }

    // EFFECTS: conducts the second question and return a String of the option chosen
    private String doChoiceTwo() {
        System.out.println("2. Which of these 2 descriptions suits you more?\n"
                + "\ts -> I assess real situations and pay attention to details.\n"
                + "\tn -> I love to dream and play over upcoming events in my mind.");
        return input.next();
    }

    // EFFECTS: conducts the third question and return a String of the option chosen
    private String doChoiceThree() {
        System.out.println("3. How are you going to make a decision?\n"
                + "\tt -> I'll weigh up all the arguments and assess the situation with a cold mind.\n"
                + "\tf -> I'll listen to my feelings. I always try to follow my heart.");
        return input.next();
    }

    // EFFECTS: conducts the fourth question and return a String of the option chosen
    private String doChoiceFour() {
        System.out.println("4. How do you prepare?\n"
                + "\tj -> I prefer to be fully armed.\n"
                + "\tp -> The best things happen spontaneously.");
        return input.next();
    }

    // EFFECTS: indicate that the log is empty if it is, otherwise print out the log
    private void doViewLog() {
        if (log.checkEmpty()) {
            System.out.println("The log is empty");
        } else {
            System.out.println(log.print());
        }
    }

    // EFFECTS: indicate that the log is empty if it is, otherwise find the result associated with
    //          the index the user inserts
    private void doChooseResult() {
        if (log.checkEmpty()) {
            System.out.println("The log is empty");
        } else {
            System.out.println(log.print());
            System.out.println("Please enter the index associated with the result:");
            int search = input.nextInt();
            System.out.println("The associated result is:");
            System.out.println(log.find(search));
        }
    }

    // MODIFIES: this
    // EFFECTS: indicate that the log is empty if it is, otherwise delete the result associated with
    //          the index the user inserts
    private void doDeleteResult() {
        if (log.checkEmpty()) {
            System.out.println("The log is empty");
        } else {
            System.out.println(log.print());
            System.out.println("Please enter the index associated with the result:");
            int search = input.nextInt();
            System.out.println(log.remove(search));
        }
    }

    // EFFECTS: saves the log to file
    private void saveLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(log);
            jsonWriter.close();
            System.out.println("Saved log to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads log from file
    private void loadLog() {
        try {
            log = jsonReader.read();
            System.out.println("Loaded log from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
