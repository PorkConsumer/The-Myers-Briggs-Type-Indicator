package ui.gui;

import javax.swing.*;
import java.awt.*;

// creates GUI components
public class CreateComponents {

    // EFFECTS: returns a JPanel with gray background and pink title
    public static JPanel makeTitlePanelGray(String title) {
        JPanel titlePanel = new JPanel();
        Font font = new Font("Bauhaus 93", Font.PLAIN, 40);
        titlePanel.setBounds(0, 50, 800, 60);
        titlePanel.setBackground(Color.darkGray);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.pink);
        titleLabel.setFont(font);
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    // EFFECTS: returns a JPanel with pink background and gray title
    public static JPanel makeTitlePanelPink(String title) {
        JPanel titlePanel = new JPanel();
        Font font = new Font("Bauhaus 93", Font.PLAIN, 40);
        titlePanel.setBounds(0, 50, 800, 60);
        titlePanel.setBackground(Color.pink);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.darkGray);
        titleLabel.setFont(font);
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    // EFFECTS: returns a JPanel with gray background and pink text
    public static JPanel makeQuestionPanelGray(String text) {
        Font font = new Font("Bauhaus 93", Font.PLAIN, 30);
        JPanel questionPanel = new JPanel();
        questionPanel.setBounds(0, 100, 800, 60);
        questionPanel.setBackground(Color.darkGray);
        JLabel questionLabel = new JLabel(text);
        questionLabel.setForeground(Color.pink);
        questionLabel.setFont(font);
        questionPanel.add(questionLabel);
        return questionPanel;
    }

    // EFFECTS: returns a JPanel with pink background and gray text
    public JPanel makeQuestionPanelPink(String text) {
        Font font = new Font("Bauhaus 93", Font.PLAIN, 30);
        JPanel questionPanel = new JPanel();
        questionPanel.setBounds(0, 100, 800, 60);
        questionPanel.setBackground(Color.darkGray);
        JLabel questionLabel = new JLabel(text);
        questionLabel.setForeground(Color.pink);
        questionLabel.setFont(font);
        questionPanel.add(questionLabel);
        return questionPanel;
    }

    // EFFECTS: returns a JButton with gray background and pink text, in size
    public static JButton makeButtonGray(String text, int size) {
        Font font = new Font("Berlin Sans FB", Font.PLAIN, size);
        JButton btn = new JButton(text);
        btn.setBackground(Color.darkGray);
        btn.setForeground(Color.pink);
        btn.setFont(font);
        btn.setFocusPainted(false);
        return btn;
    }

    // EFFECTS: returns a JButton with pink background and gray text, in size
    public static JButton makeButtonPink(String text, int size) {
        Font font = new Font("Berlin Sans FB", Font.PLAIN, size);
        JButton btn = new JButton(text);
        btn.setBackground(Color.pink);
        btn.setForeground(Color.darkGray);
        btn.setFont(font);
        btn.setFocusPainted(false);
        return btn;
    }
}
