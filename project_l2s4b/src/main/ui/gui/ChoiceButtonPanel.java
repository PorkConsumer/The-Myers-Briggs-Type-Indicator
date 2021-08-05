package ui.gui;

import model.Log;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// develops GUI for ChoiceButtonPanel
public class ChoiceButtonPanel {

    private Container con;
    private Log log;
    private JPanel choiceButtonPanel;
    private JPanel namePanel;
    private JButton addTest;
    private JButton viewLog;
    private JButton saveLog;
    private JButton loadLog;
    private String position;

    private ChoiceHandler choiceHandler = new ChoiceHandler();
    private PlaySound sound = new PlaySound();

    private static final String JSON_STORE = "./data/log.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs a new ChoiceButtonPanel GUI
    public ChoiceButtonPanel(Container con, Log log) {
        this.con = con;
        this.log = log;
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        con.removeAll();
        con.setBackground(Color.pink);

        namePanel = createScreen();
        con.add(namePanel);
        choiceButtonPanel = makeChoiceButtonPanel();
        con.add(choiceButtonPanel);
        mainScreen();

        con.revalidate();
    }

    // EFFECTS: creates/returns panel with program title
    public JPanel createScreen() {
        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 50, 800, 200);
        namePanel.setBackground(Color.darkGray);
        JLabel nameLabel = new JLabel("<html><b>The Myers–Briggs Type Indicator</b>"
                + "<br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <font size=\"10\">A Psychology Test</font>"
                + "<br>-----------------------------------------------------------------------</html>");
        nameLabel.setForeground(Color.pink);
        nameLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
        namePanel.add(nameLabel);
        return namePanel;
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel with four choices
    public JPanel makeChoiceButtonPanel() {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100,350,600,150);
        choiceButtonPanel.setBackground(Color.pink);
        choiceButtonPanel.setLayout(new GridLayout(4,1));

        addTest = CreateComponents.makeButtonGray("Add Test",25);
        addTest.addActionListener(choiceHandler);
        addTest.setActionCommand("addTest");
        choiceButtonPanel.add(addTest);

        viewLog = CreateComponents.makeButtonGray("View Log",25);
        viewLog.addActionListener(choiceHandler);
        viewLog.setActionCommand("viewLog");
        choiceButtonPanel.add(viewLog);

        saveLog = CreateComponents.makeButtonGray("Save Log",25);
        saveLog.addActionListener(choiceHandler);
        saveLog.setActionCommand("saveLog");
        choiceButtonPanel.add(saveLog);

        loadLog = CreateComponents.makeButtonGray("Load Log",25);
        loadLog.addActionListener(choiceHandler);
        loadLog.setActionCommand("loadLog");
        choiceButtonPanel.add(loadLog);
        return choiceButtonPanel;
    }

    // MODIFIES: this
    // EFFECTS: sets position to be "addTest"
    //          hides choice and title panel
    //          constructs new NamePanel gui
    public void addTest() {
        position = "addTest";
        choiceButtonPanel.setVisible(false);
        namePanel.setVisible(false);
        con.setBackground(Color.darkGray);
        new NamePanel(con, log);
    }

    // MODIFIES: this
    // EFFECTS: sets position to be "viewLog"
    //          hides choice and title panel
    //          constructs new viewLog gui
    public void viewLog() {
        position = "viewLog";
        choiceButtonPanel.setVisible(false);
        namePanel.setVisible(false);
        new ViewLogPanel(con, log);
    }

    // MODIFIES: this
    // EFFECTS: sets position to be "saveLog"
    //          hides choice and title panel
    //          constructs new saveLog gui
    public void saveLog() {
        position = "saveLog";
        choiceButtonPanel.setVisible(false);
        try {
            jsonWriter.open();
            jsonWriter.write(log);
            jsonWriter.close();
            new SaveLoadLogPanel(con, log);
        } catch (FileNotFoundException e) {
            choiceButtonPanel.setVisible(true);
        }
    }

    // MODIFIES: this
    // EFFECTS: sets position to be "loadLog"
    //          hides choice and title panel
    //          constructs new loadLog gui
    public void loadLog() {
        position = "loadLog";
        choiceButtonPanel.setVisible(false);
        try {
            log = jsonReader.read();
            new SaveLoadLogPanel(con, log);
        } catch (IOException e) {
            choiceButtonPanel.setVisible(true);
        }
    }

    // MODIFIES: this
    // EFFECTS: sets position to be "mainScreen"
    public void mainScreen() {
        position = "mainScreen";
    }


    // EFFECTS: plays a sound when an action event is made
    //          handles the choices made by the user depending on position
    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            String yourChoice = e.getActionCommand();
            switch (position) {
                case "mainScreen":
                    switch (yourChoice) {
                        case "addTest": addTest();
                            break;
                        case "viewLog": viewLog();
                            break;
                        case "saveLog": saveLog();
                            break;
                        case "loadLog": loadLog();
                            break;
                    } break;
            }
        }
    }
}