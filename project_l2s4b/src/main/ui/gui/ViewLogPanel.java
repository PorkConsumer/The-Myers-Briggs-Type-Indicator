package ui.gui;

import model.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// develops GUI for ViewLogPanel
public class ViewLogPanel {

    private Container con;
    private Log log;
    private JPanel viewPanel;
    private JTextField find;

    private ViewPanelHandler viewPanelHandler = new ViewPanelHandler();
    private PlaySound sound = new PlaySound();

    // EFFECTS: constructs a new ViewLogPanel GUI
    public ViewLogPanel(Container con, Log log) {
        this.con = con;
        this.log = log;
        con.setBackground(Color.darkGray);
        viewPanel = makeViewPanel();
        con.add(viewPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates/returns panel showing the log's contents
    public JPanel makeViewPanel() {
        JPanel viewPanel = new JPanel();
        JPanel title = CreateComponents.makeTitlePanelPink("View Log              ");
        viewPanel.setBackground(Color.pink);
        viewPanel.setBounds(95,50,600,450);
        viewPanel.add(title);

        JTextArea mainTextArea = new JTextArea(log.print());
        mainTextArea.setBounds(70, 110, 530, 400);
        mainTextArea.setBackground(Color.pink);
        mainTextArea.setForeground(Color.darkGray);
        mainTextArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
        mainTextArea.setLineWrap(true);

        find = makeFindIndexTextField();
        JButton findIndex = CreateComponents.makeButtonGray("Find Index",20);
        findIndex.setActionCommand("findIndex");
        findIndex.addActionListener(viewPanelHandler);

        JButton btn = CreateComponents.makeButtonGray(" -> ",25);
        btn.setActionCommand("returnFromViewPanel");
        btn.addActionListener(viewPanelHandler);

        viewPanel.add(find);
        viewPanel.add(findIndex);
        viewPanel.add(mainTextArea);
        viewPanel.add(btn);
        return viewPanel;
    }

    // EFFECTS: creates/returns a text field
    public JTextField makeFindIndexTextField() {
        JTextField textField = new JTextField(7);
        textField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
        return textField;
    }

    // MODIFIES: this
    // EFFECTS: plays a sound when an action event is made
    //          hides viewPanel panels and returns to the main screen
    //          if action command is "returnFromViewPanel"
    //          else hide viewPanel and make a new FindPanel
    public class ViewPanelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sound.playSound("music\\\\Button Plate Click.wav");
            if (e.getActionCommand().equals("returnFromViewPanel")) {
                viewPanel.setVisible(false);
                new ChoiceButtonPanel(con, log);
            } else if (e.getActionCommand().equals("findIndex")) {
                try {
                    viewPanel.setVisible(false);
                    new FindPanel(con, log, Integer.parseInt(find.getText()));
                } catch (Exception exception) {
                    viewPanel.setVisible(true);
                }
            }
        }
    }
}
