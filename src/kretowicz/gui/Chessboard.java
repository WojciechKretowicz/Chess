package kretowicz.gui;


import kretowicz.engine.Engine;
import kretowicz.figures.Figure;

import javax.swing.*;
import java.awt.*;

public class Chessboard extends JPanel {
    int x, y;
    private Tile[][] tiles;
    private Dimension screenSize;
    private Figure movingFigure;

    public Chessboard(Dimension screenSize, Engine engine) {

        setMaximumSize(new Dimension(screenSize.width / 2, screenSize.width / 2));

        setLayout(new GridLayout(8, 8));

        tiles = new Tile[8][8];
        this.screenSize = screenSize;
        setBackground(Color.GRAY);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0)
                    tiles[i][j] = new Tile(Color.WHITE, i, j, engine);
                else
                    tiles[i][j] = new Tile(Color.gray, i, j, engine);
                add(tiles[i][j]);
            }
        }
    }

    public Tile getTile(int i, int j) {
        return tiles[i][j];
    }

    public void setMovingFigure(Figure figure, int x, int y) {
        this.movingFigure = figure;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (movingFigure != null) {
            g.drawImage(movingFigure.img, x, y, null);
        }
    }
}
