package kretowicz.figures;

import kretowicz.engine.Engine;
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
    public Pawn(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard,engine);
    }

    @Override
    public boolean check(Tile lastTile) {
        return moveForward(lastTile) ||
                moveForwardLong(lastTile);
    }

    public boolean moveForward(Tile lastTile) {
        int d = color ? -1 : 1;
        if(tile.getXPos() == lastTile.getXPos() - d)
            return true;
        return false;
    }

    public boolean moveForwardLong(Tile lastTile) {
        int d = color ? -2 : 2;
        if(engine.getTurn() == color && tile.getXPos() == lastTile.getXPos() - d) {
            if(engine.getTurn() && engine.getFirstWhiteTurn())
                return true;
            else if(!engine.getTurn() && engine.getFirstBlackTurn())
                return true;
        }
        return false;
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
