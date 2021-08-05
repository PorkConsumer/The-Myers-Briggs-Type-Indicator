package ui.gui;

import model.Log;
import model.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// develops GUI for AddTestPanel
public class AddTestPanel {

    private Container con;
    private JPanel testChoiceButtonPanel;
    private JPanel choiceOnePanel;
    private JPanel questionOnePanel;
    private JPanel choiceTwoPanel;
    private JPanel questionTwoPanel;
    private JPanel choiceThreePanel;
    private JPanel questionThreePanel;
    private JPanel choiceFourPanel;
    private JPanel questionFourPanel;
    private JPanel labelPanel;
    private JPanel descriptionPanel;
    private JButton choice1;
    private JButton choice2;
    private String name;
    private String label;
    private Log log;

    private FirstChoiceHandler firstChoiceHandler = new FirstChoiceHandler();
    private SecondChoiceHandler secondChoiceHandler = new SecondChoiceHandler();
    private ThirdChoiceHandler thirdChoiceHandler = new ThirdChoiceHandler();
    private FourthChoiceHandler fourthChoiceHandler = new FourthChoiceHandler();
    private ResultHandler resultHandler = new ResultHandler();
    private PlaySound sound = new PlaySound();

    // EFFECTS: constructs a new AddTestPanel GUI
    public AddTestPanel(Container con, String name, Log log) {
        this.con = con;
        this.name = name;
        this.log = log;
        testChoiceButtonPanel = makeTestChoicePanel();
        con.add(testChoiceButtonPanel);
        firstChoice();
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel with two choices
    public JPanel makeTestChoicePanel() {
        JPanel testChoiceButtonPanel = new JPanel();
        testChoiceButtonPanel.setBounds(95,200,600,250);
        testChoiceButtonPanel.setBackground(Color.pink);
        testChoiceButtonPanel.setLayout(new GridLayout(2,1));

        choice1 = CreateComponents.makeButtonPink("<html><b>E</b> "
                + "-> I'll call my friends to all go out together</html>", 25);
        choice1.addActionListener(firstChoiceHandler);
        choice1.setActionCommand("c1");
        testChoiceButtonPanel.add(choice1);

        choice2 = CreateComponents.makeButtonPink("<html><b>I</b> -> I'll switch on the \"Don't disturb\" "
                + "mode on my<br/> &nbsp &nbsp &nbsp &nbsp phone and stay at home</html>", 25);
        choice2.addActionListener(firstChoiceHandler);
        choice2.setActionCommand("c2");
        testChoiceButtonPanel.add(choice2);
        return testChoiceButtonPanel;
    }

    // MODIFIES: this
    // EFFECTS: create/add panels related to question one
    public void firstChoice() {
        choiceOnePanel = CreateComponents.makeTitlePanelGray("Question 1");
        questionOnePanel = CreateComponents.makeQuestionPanelGray("How are you going to spend your weekend?");
        con.add(choiceOnePanel);
        con.add(questionOnePanel);
    }

    // MODIFIES: this
    // EFFECTS: hides panels related to question one
    //          create/add panels related to question two
    //          modifies the choices' action listener and texts to fit answers to question two
    public void secondChoice() {
        choiceOnePanel.setVisible(false);
        questionOnePanel.setVisible(false);

        choiceTwoPanel = CreateComponents.makeTitlePanelGray("Question 2");
        questionTwoPanel = CreateComponents.makeQuestionPanelGray("Which of these 2 descriptions suits you more?");
        con.add(choiceTwoPanel);
        con.add(questionTwoPanel);
        choice1.removeActionListener(firstChoiceHandler);
        choice2.removeActionListener(firstChoiceHandler);
        choice1.addActionListener(secondChoiceHandler);
        choice2.addActionListener(secondChoiceHandler);
        choice1.setText("<html><b>S</b> -> I assess real situations and pay attention to details</html>");
        choice2.setText("<html><b>N</b> -> I love to dream and play over upcoming events"
                + "&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp in my mind</html>");
    }

    // MODIFIES: this
    // EFFECTS: hides panels related to question two
    //          create/add panels related to question three
    //          modifies the choices' action listener and texts to fit answers to question three
    public void thirdChoice() {
        choiceTwoPanel.setVisible(false);
        questionTwoPanel.setVisible(false);

        choiceThreePanel = CreateComponents.makeTitlePanelGray("Question 3");
        questionThreePanel = CreateComponents.makeQuestionPanelGray("How are you going to make a decision?");
        con.add(choiceThreePanel);
        con.add(questionThreePanel);
        choice1.removeActionListener(secondChoiceHandler);
        choice2.removeActionListener(secondChoiceHandler);
        choice1.addActionListener(thirdChoiceHandler);
        choice2.addActionListener(thirdChoiceHandler);
        choice1.setText("<html><b>T</b> -> I'll weigh up all the arguments and assess the &nbsp &nbsp &nbsp "
                + "&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp situation with a cold mind</html>");
        choice2.setText("<html><b>F</b> -> I'll listen to my feelings."
                + "I always try to follow my &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp heart.</html>");
    }

    // MODIFIES: this
    // EFFECTS: hides panels related to question three
    //          create/add panels related to question four
    //          modifies the choices' action listener and texts to fit answers to question four
    public void fourthChoice() {
        choiceThreePanel.setVisible(false);
        questionThreePanel.setVisible(false);

        choiceFourPanel = CreateComponents.makeTitlePanelGray("Question 4");
        questionFourPanel = CreateComponents.makeQuestionPanelGray("How do you prepare?");
        con.add(choiceFourPanel);
        con.add(questionFourPanel);
        choice1.removeActionListener(thirdChoiceHandler);
        choice2.removeActionListener(thirdChoiceHandler);
        choice1.addActionListener(fourthChoiceHandler);
        choice2.addActionListener(fourthChoiceHandler);
        choice1.setText("<html><b>J</b> -> I prefer to be fully armed</html>");
        choice2.setText("<html><b>P</b> -> The best things happen spontaneously</html>");
    }

    // MODIFIES: this
    // EFFECTS: hides panels related to question four
    //          create/add panels to display result description
    //          create button to return to main screen
    public void makeResultPanel() {
        choiceFourPanel.setVisible(false);
        questionFourPanel.setVisible(false);
        testChoiceButtonPanel.setVisible(false);

        labelPanel = CreateComponents.makeTitlePanelGray(label.toUpperCase());
        con.add(labelPanel);
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(95,110,600, 400);
        descriptionPanel.setBackground(Color.pink);
        con.add(descriptionPanel);

        JTextArea mainTextArea = new JTextArea(new Result(name, label).getDescription());
        mainTextArea.setBounds(95, 110, 600, 400);
        mainTextArea.setBackground(Color.pink);
        mainTextArea.setForeground(Color.darkGray);
        mainTextArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
        mainTextArea.setLineWrap(true);
        descriptionPanel.add(mainTextArea);

        JButton btn = CreateComponents.makeButtonGray(" -> ", 25);
        btn.setActionCommand("returnFromTest");
        btn.addActionListener(resultHandler);
        descriptionPanel.add(btn);
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          modifies label depending on option selected from question one
    //          proceeds to the next question if action command is "c1" or "c2"
    public class FirstChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("c1")) {
                label = "e";
                secondChoice();
            } else if (e.getActionCommand().equals("c2")) {
                label = "i";
                secondChoice();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          modifies label depending on option selected from question two
    //          proceeds to the next question if action command is "c1" or "c2"
    public class SecondChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("c1")) {
                label = label + "s";
                thirdChoice();
            } else if (e.getActionCommand().equals("c2")) {
                label = label + "n";
                thirdChoice();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          modifies label depending on option selected from question three
    //          proceeds to the next question if action command is "c1" or "c2"
    public class ThirdChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("c1")) {
                label = label + "t";
                fourthChoice();
            } else if (e.getActionCommand().equals("c2")) {
                label = label + "f";
                fourthChoice();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          modifies label depending on option selected from question four
    //          proceeds to generate the result if action command is "c1" or "c2"
    public class FourthChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("c1")) {
                label = label + "j";
                makeResultPanel();
            } else if (e.getActionCommand().equals("c2")) {
                label = label + "p";
                makeResultPanel();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          generate the result from label and store that result in log, then returns to the main screen
    //          if action command is "returnFromTest"
    public class ResultHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("returnFromTest")) {
                log.insert(new Result(name,label));
                new ChoiceButtonPanel(con, log);
            }
        }
    }
}