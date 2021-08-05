package ui.gui;

import model.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// develops GUI for FindPanel
public class FindPanel {
    private Container con;
    private Log log;
    private Integer index;
    private JPanel findPanel;

    private FindPanelHandler findPanelHandler = new FindPanelHandler();
    private PlaySound sound = new PlaySound();

    // EFFECTS: constructs a new FindPanel GUI
    public FindPanel(Container con, Log log, Integer index) {
        this.con = con;
        this.log = log;
        this.index = index;
        findPanel = makeFindPanel();
        con.add(findPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel with a text box containing a result
    public JPanel makeFindPanel() {
        JPanel findPanel = new JPanel();
        JPanel title = CreateComponents.makeTitlePanelPink("Result:");
        findPanel.setBackground(Color.pink);
        findPanel.setBounds(95,50,600,450);
        findPanel.add(title);

        JTextArea mainTextArea = new JTextArea(log.find(index));
        mainTextArea.setBounds(70, 110, 530, 400);
        mainTextArea.setBackground(Color.pink);
        mainTextArea.setForeground(Color.darkGray);
        mainTextArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
        mainTextArea.setLineWrap(true);

        JButton btn = CreateComponents.makeButtonGray(" -> ",24);
        btn.setActionCommand("returnFromFind");
        btn.addActionListener(findPanelHandler);

        findPanel.add(mainTextArea);
        findPanel.add(btn);
        con.add(findPanel);
        return findPanel;
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          hides findPanel and returns to ViewLog
    //          if action command is "returnFromFind"
    public class FindPanelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("returnFromFind")) {
                findPanel.setVisible(false);
                new ViewLogPanel(con,log);
            }
        }
    }
}
