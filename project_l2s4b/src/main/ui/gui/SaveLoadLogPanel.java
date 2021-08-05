package ui.gui;

import model.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// develops GUI for SaveLoadLogPanel
public class SaveLoadLogPanel {
    private Container con;
    private JPanel saveLoadPanel;
    private Log log;

    private SaveLoadLogPanelHandler saveLoadLogPanelHandler = new SaveLoadLogPanelHandler();
    private PlaySound sound = new PlaySound();

    // EFFECTS: constructs a new SaveLoadLogPanel GUI
    public SaveLoadLogPanel(Container con, Log log) {
        this.con = con;
        this.log = log;
        con.setBackground(Color.darkGray);
        saveLoadPanel = makeSaveLoadPanel();
        con.add(saveLoadPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel to indicate that the save/load was successful
    public JPanel makeSaveLoadPanel() {
        JPanel saveLoadPanel = CreateComponents.makeTitlePanelGray("Successful!");
        saveLoadPanel.setBounds(100,400,600,200);

        JButton btn = CreateComponents.makeButtonGray("->",35);
        btn.setActionCommand("successSaveLoad");
        btn.addActionListener(saveLoadLogPanelHandler);

        saveLoadPanel.add(btn);
        return saveLoadPanel;
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          hides saveLoadPanel and returns to main screen
    //          if action command is "successSaveLoad"
    public class SaveLoadLogPanelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("successSaveLoad")) {
                saveLoadPanel.setVisible(false);
                new ChoiceButtonPanel(con, log);
            }
        }
    }
}
