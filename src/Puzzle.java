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

        String[] numberOrder = new String[size*size];
        for (int i = 0; i < numberOrder.length; i++) {
            numberOrder[i] = String.valueOf(i + 1);
        }
        numberOrder[size*size-1] = String.valueOf(size*size-1);
        numberOrder[size*size-2] = "";

        int x = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton(numberOrder[x++]);
                buttons[i][j].setBackground(Color.white);
                buttons[i][j].setForeground(Color.blue);
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                //buttons[i][j].addActionListener(l);
                gridPanel.add(buttons[i][j]);
            }
        }
        //shuffle();

    }
}
