package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ChessGrid {

    public static void main(String[] args) {
        new ChessGrid();
    }

    private ChessGrid() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new TestPane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;
                    Grid cellPane = new Grid();
                    Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    cellPane.setBorder(border);

                    JLabel jLabel;
                    if(row==1 || row==6){
                        jLabel = new JLabel("Pawn");
                        if(row==1){
                            jLabel.setForeground(Color.WHITE);
                        }
                        cellPane.add(jLabel);
                    }else if(row==0 || row==7){
                        if(col==0 || col==7){
                            jLabel = new JLabel("Rook");
                        }else if(col==1 || col==5){
                            jLabel = new JLabel("Knight");
                        }else if(col==2 || col==4){
                            jLabel = new JLabel("Bishop");
                        }else if(col==3){
                            jLabel = new JLabel("Queen");
                        }else{
                            jLabel = new JLabel("King");
                        }
                        if(row==0){
                            jLabel.setForeground(Color.WHITE);
                        }
                        cellPane.add(jLabel);
                    }

                    if(row%2==0){
                        if(col%2!=0){
                            cellPane.setBackground(Color.LIGHT_GRAY);
                        }else{
                            cellPane.setBackground(Color.GRAY);
                        }
                    }else{
                        if(col%2!=0){
                            cellPane.setBackground(Color.GRAY);
                        }else{
                            cellPane.setBackground(Color.LIGHT_GRAY);
                        }
                    }
                    add(cellPane, gbc);
                }
            }
        }
    }

    public class Grid extends JPanel {

//        private Color defaultBackground;
//        public Grid() {
//            addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    defaultBackground = getBackground();
////                    setBackground(Color.BLUE);
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    setBackground(defaultBackground);
//                }
//            });
//        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(70, 70);
        }

    }
}