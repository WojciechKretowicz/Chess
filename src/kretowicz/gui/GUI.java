package kretowicz.gui;

import kretowicz.engine.Engine;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private Chessboard chessboard;
    private Dimension screenSize;
    private JPanel backgroundPanel;

    public GUI(Engine engine) {

        // setting screen size
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setBackground(Color.BLACK);
        frame.add(backgroundPanel);

        chessboard = new Chessboard(screenSize, engine);
        backgroundPanel.add(chessboard);
    }

    public void show() {
        frame.setVisible(true);
    }

    public Chessboard getChessboard() {
        return chessboard;
    }
}
