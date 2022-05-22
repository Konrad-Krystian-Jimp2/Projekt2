package com.example.jimp2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingGraph {

    public static void main(String[] args) {
        new DrawingGraph();
    }

    public DrawingGraph() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Grafexe");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setMinimumSize(new Dimension(480, 480));
            }
        });
    }

    public class TestPane extends JPanel {

        private int columnCount = 10;
        private int rowCount = 20;
        private List<Rectangle> cells;

        private Point selectedCell;
        public TestPane() {
            //cells = new ArrayList<>(columnCount * rowCount);
            cells= new ArrayList<>(columnCount * rowCount);
            MouseAdapter mouseHandler;
            mouseHandler = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    //Point point = e.getPoint();

                    int width = getWidth();
                    int height = getHeight();

                    int cellWidth = width / columnCount;
                    int cellHeight = height / rowCount;
                    if (cellWidth<cellHeight)
                        cellHeight=cellWidth;
                    else
                        cellWidth=cellHeight;
                    int xOffset = (width - (columnCount * cellWidth)) / 2;
                    int yOffset = (height - (rowCount * cellHeight)) / 2;
                    selectedCell = null;
                    if (e.getX() >= xOffset && e.getY() >= yOffset) {

                        int column = (e.getX() - xOffset) / cellWidth;
                        int row = (e.getY() - yOffset) / cellHeight;

                        if (column >= 0 && row >= 0 && column < columnCount && row < rowCount) {

                            selectedCell = new Point(column, row);

                        }

                    }
                    repaint();

                }
            };
            addMouseMotionListener(mouseHandler);
        }

        @Override
        public Dimension getPreferredSize() {
            double ratio=rowCount/columnCount;
            if(ratio>=1.75) {
                return new Dimension(480, 720);
            }
            if(ratio<=0.75) {
                return new Dimension(720, 480);
            }
            else {
                return new Dimension(640, 640);
            }
        }

        @Override
        public void invalidate() {
            cells.clear();
            selectedCell = null;
            super.invalidate();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();

            int cellWidth = width / columnCount;
            int cellHeight = height / rowCount;
            if (cellWidth<cellHeight)
                cellHeight=cellWidth;
            else
                cellWidth=cellHeight;
            int xOffset = (width - (columnCount * cellWidth)) / 2;
            int yOffset = (height - (rowCount * cellHeight)) / 2;

            if (cells.isEmpty()) {
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        Rectangle cell = new Rectangle(xOffset + (col * cellWidth),yOffset + (row * cellHeight),cellWidth,cellHeight);
                        cells.add(cell);
                    }
                }
            }

            if (selectedCell != null) {//wybrane pole:

                int index = selectedCell.x + (selectedCell.y * columnCount);
                Rectangle cell = cells.get(index);
                g2d.setColor(Color.BLUE);
                g2d.fill(cell);

            }
            //kolor siatki:
            g2d.setColor(Color.BLACK);
            for (Rectangle cell : cells) {
                g2d.draw(cell);
            }

            g2d.dispose();
        }
    }
}