package kretowicz.figures;

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
    public King(boolean color, Chessboard chessboard) {
        super(color, chessboard);
        try {
            BufferedImage pic;
            if(color)
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\white king.png"));
            else
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\black king.png"));

            Image scaledPic = pic.getScaledInstance(150, 150,
                    Image.SCALE_SMOOTH);
            picture = new JLabel(new ImageIcon(scaledPic));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void moveForward() {
        int d=1;
        if(color)
            d=-1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()).setFigure(this);
    }

    public void moveBack() {
        int d=-1;
        if(color)
            d=1;
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

    public void moveBackRight(){
        int d=-1;
        if(color)
            d=1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()-d).setFigure(this);
    }

    public void moveBackLeft() {
        int d=-1;
        if(color)
            d=1;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+d,tile.getYPos()+d).setFigure(this);
    }

}
