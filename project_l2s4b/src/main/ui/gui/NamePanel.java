package ui.gui;

import model.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// develops GUI for NamePanel
public class NamePanel {

    private Container con;
    private JPanel nameTitlePanel;
    private JPanel nameQuestionPanel;
    private JPanel namePanel;
    private JTextField field;
    private String name;
    private Log log;

    private ToFirstChoiceHandler toFirstChoiceHandler = new ToFirstChoiceHandler();
    private PlaySound sound = new PlaySound();

    // EFFECTS: constructs a new NamePanel GUI
    public NamePanel(Container con, Log log) {
        this.con = con;
        this.log = log;
        nameTitlePanel = CreateComponents.makeTitlePanelGray("What is your name?");
        nameQuestionPanel = CreateComponents.makeQuestionPanelGray("Please enter:");
        con.add(nameTitlePanel);
        con.add(nameQuestionPanel);
        namePanel = makeNamePanel();
        con.add(namePanel);
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel with a text box and a button
    //          to accept user input for their name
    public JPanel makeNamePanel() {
        name = "";
        namePanel = new JPanel();
        field = new JTextField(10);
        field.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
        field.setBounds(95,300,600,150);
        namePanel.setBackground(Color.pink);
        namePanel.setBounds(95,300,600,150);

        JButton btn = CreateComponents.makeButtonGray("->",35);
        btn.setActionCommand("toFirstChoice");
        btn.addActionListener(toFirstChoiceHandler);

        namePanel.add(field);
        namePanel.add(btn);
        return namePanel;
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          hides NamePanel panels, passes name to make a new AddTestPanel
    //          if action command is "toFirstChoice"
    public class ToFirstChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("toFirstChoice")) {
                nameTitlePanel.setVisible(false);
                nameQuestionPanel.setVisible(false);
                namePanel.setVisible(false);
                name = field.getText();
                new AddTestPanel(con, name, log);
            }
        }
    }
}