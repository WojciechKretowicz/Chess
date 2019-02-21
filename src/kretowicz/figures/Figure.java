package kretowicz.figures;

import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.swing.*;

public abstract class Figure {
    protected JLabel picture;
    protected boolean color;
    protected Tile tile;
    protected Chessboard chessboard;

    public Figure(boolean color, Chessboard chessboard) {
        this.color = color;
        this.chessboard = chessboard;
    }

    public JLabel getPicture() {
        return picture;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
