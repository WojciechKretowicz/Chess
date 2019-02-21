package kretowicz.figures;

import kretowicz.gui.Chessboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rook extends Figure {
    public Rook(boolean color, Chessboard chessboard) {
        super(color, chessboard);

    }

    public void moveVertically(int n) {
        if(color)
            n=-n;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+n,tile.getYPos()).setFigure(this);
    }
}
