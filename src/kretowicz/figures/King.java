package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class King extends Figure {
    public King(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard, engine);

    }

    @Override
    protected boolean check() {
        int dVertically =
                Math.abs(tile.getXPos() - engine.getLastTile().getXPos());
        int dHorizontally =
                Math.abs(tile.getYPos() - engine.getLastTile().getYPos());

        if(dVertically <= 1 && dHorizontally <= 1 && dHorizontally + dVertically != 0) {
            if(engine.getLastTile().getFigure() != null &&
                    engine.getLastTile().getFigure().color == color)
                return false;
            return true;
        }

        return false;
    }
}
