package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Knight extends Figure {
    public Knight(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard,engine);

    }

    @Override
    protected boolean check() {
        if((Math.abs(tile.getXPos() - engine.getLastTile().getXPos()) != 2 ||
                Math.abs(tile.getYPos() - engine.getLastTile().getYPos()) != 1) &&
                (Math.abs(tile.getYPos() - engine.getLastTile().getYPos()) != 2 ||
                        Math.abs(tile.getXPos() - engine.getLastTile().getXPos()) != 1))
            return false;

        if(engine.getLastTile().getFigure() != null &&
                engine.getLastTile().getFigure().color == color)
            return false;

        return true;
    }
}
