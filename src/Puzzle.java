import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Max Erling
 * Date: 2020-10-23
 * Copyright: MIT
 * Class: Java20B
 */

public class Puzzle extends JFrame {
    private Random random = new Random();
    private JButton[][] buttons;
    private JButton newGame = new JButton("Nytt spel");
    private int size;

    public Puzzle(int size) {
        this.size = size;
        buttons = new JButton[size][size];

        JPanel sidePanel = new JPanel();
        JPanel gridPanel = new JPanel(new GridLayout(size, size));

        newGame.setBackground(Color.white);
        //buttonListener l = new buttonListener();
        //newGame.addActionListener(l);

        sidePanel.add(newGame);

        JPanel mainPanel = new JPanel();
        mainPanel.add(gridPanel, BorderLayout.WEST);
        mainPanel.add(sidePanel, BorderLayout.EAST);

        add(mainPanel);

    }
}
