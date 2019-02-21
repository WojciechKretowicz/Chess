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
        try {
            BufferedImage pic;
            if(color)
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\white rook.png"));
            else
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\black rook.png"));

            Image scaledPic = pic.getScaledInstance(150, 150,
                    Image.SCALE_SMOOTH);
            picture = new JLabel(new ImageIcon(scaledPic));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void moveVertically(int n) {
        if(color)
            n=-n;
        tile.setFigure(null);
        chessboard.getTile(tile.getXPos()+n,tile.getYPos()).setFigure(this);
    }
}
