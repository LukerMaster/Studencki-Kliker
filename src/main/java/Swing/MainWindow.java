package Swing;

import javax.swing.*;

public class MainWindow {
    private JButton ChopTreeButton;
    private JPanel panel;
    private JList ResourceList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {

    }
}
