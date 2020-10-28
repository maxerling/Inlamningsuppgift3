import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 500);
        setVisible(true);
        setResizable(false);
        pack();

    }

    public static void main(String[] args) {
        new Puzzle(4);
    }

    class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == newGame) {
                shuffle();
            }

            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    if (e.getSource() == buttons[i][j]) {
                        String s = buttons[i][j].getText();


                        if (i != 0) {
                            if (buttons[i - 1][j].getText().equalsIgnoreCase("")) {
                                buttons[i - 1][j].setText(s);
                                buttons[i][j].setText("");
                            }
                        }


                        if (i != size - 1) {
                            if (buttons[i + 1][j].getText().equals("")) {
                                buttons[i + 1][j].setText(s);
                                buttons[i][j].setText("");
                            }
                        }

                        if (j != 0) {
                            if (buttons[i][j - 1].getText().equalsIgnoreCase("")) {
                                buttons[i][j - 1].setText(s);
                                buttons[i][j].setText("");
                            }
                        }

                        if (j != size - 1) {
                            if (buttons[i][j + 1].getText().equals("")) {
                                buttons[i][j + 1].setText(s);
                                buttons[i][j].setText("");

                            }
                        }
                    }

                }

            if (isSolved()) {
                JOptionPane.showMessageDialog(null, "Grattis, du vann!");
            }
        }
    }

}
