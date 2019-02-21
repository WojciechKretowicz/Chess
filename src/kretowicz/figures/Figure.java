package kretowicz.figures;

import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Figure {
    protected JLabel picture;
    public Image img;
    protected boolean color;
    protected Tile tile;
    protected Chessboard chessboard;
    protected static String path = "C:\\Users\\Admin\\Desktop\\chess icons\\";

    public Figure(boolean color, Chessboard chessboard) {
        this.color = color;
        this.chessboard = chessboard;
        picture = new JLabel();

        try {
            BufferedImage pic;
            if(color)
                pic = ImageIO.read(new File(path + "white " + this.getClass().getSimpleName() + ".png"));
            else
                pic = ImageIO.read(new File(path + "black " + this.getClass().getSimpleName() + ".png"));

            Image scaledPic = pic.getScaledInstance(150, 150,
                    Image.SCALE_SMOOTH);
            picture.setIcon(new ImageIcon(scaledPic));

            img = scaledPic;

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public JLabel getPicture() {
        return picture;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
