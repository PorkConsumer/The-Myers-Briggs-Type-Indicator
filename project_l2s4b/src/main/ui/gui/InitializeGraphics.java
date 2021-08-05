package ui.gui;

import model.Log;

import javax.swing.*;
import java.awt.*;

// develops GUI for Personality Test Application
public class InitializeGraphics {

    private Log log;
    private JFrame window;
    private Container con;

    // constructs a new GUI
    public InitializeGraphics() {
        log = new Log();
        window = new JFrame("The Myers–Briggs Type Indicator");
        window.setSize(800, 600);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.pink);
        con = window.getContentPane();

        new ChoiceButtonPanel(con, log);
        window.setVisible(true);
    }
}
