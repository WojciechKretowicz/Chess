package kretowicz.gui;


import javax.swing.*;
import java.awt.*;

public class Chessboard extends JPanel {
    private Tile [][] tiles;
    private Dimension screenSize;
    private JPanel margin;

    public Chessboard(Dimension screenSize) {

        setMaximumSize(new Dimension(screenSize.width/2, screenSize.width/2));

        setLayout(new GridLayout(8,8));

        tiles = new Tile[8][8];
        this.screenSize = screenSize;
        setBackground(Color.GRAY);
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0)
                    tiles[i][j] = new Tile(Color.WHITE, i, j);
                else
                    tiles[i][j] = new Tile(Color.gray, i, j);
                add(tiles[i][j]);
            }
        }
    }

    public Tile getTile(int i, int j) {
        return tiles[i][j];
    }
}
