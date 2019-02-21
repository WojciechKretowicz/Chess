package kretowicz.figures;

import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pawn extends Figure {
    public Pawn(boolean color, Chessboard chessboard) {
            super(color, chessboard);
        }

    public void moveForward() {
        int d=1;
        if(color)
            d=-1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()).setFigure(this);
    }

    public void moveForwardLong() {
        int d=2;
        if(color)
            d=-2;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()).setFigure(this);
    }

    public void moveForwardRight() {
        int d=1;
        if(color)
            d=-1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()-d).setFigure(this);
    }

    public void moveForwardLeft() {
        int d=1;
        if(color)
            d=-1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()+d).setFigure(this);
    }


}
