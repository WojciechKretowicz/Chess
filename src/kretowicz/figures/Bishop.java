package kretowicz.figures;

import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bishop extends Figure {
    public Bishop(boolean color, Chessboard chessboard) {
        super(color, chessboard);
        try {
            BufferedImage pic;
            if(color)
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\white bishop.png"));
            else
                pic = ImageIO.read(new File("C:\\Users\\Admin\\Desktop\\chess icons\\black bishop.png"));

            Image scaledPic = pic.getScaledInstance(150, 150,
                    Image.SCALE_SMOOTH);
            picture = new JLabel(new ImageIcon(scaledPic));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
