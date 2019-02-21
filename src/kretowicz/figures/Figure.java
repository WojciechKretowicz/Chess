package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    protected Engine engine;

    public Figure(boolean color, Chessboard chessboard, Engine engine) {
        this.color = color;
        this.chessboard = chessboard;
        this.engine = engine;
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

        Figure tmp = this;
        picture.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if(engine.getTurn() == color) {
                    chessboard.setMovingFigure(tmp, e.getXOnScreen() - 710, e.getYOnScreen() - 110);
                    picture.setVisible(false);
                    chessboard.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        picture.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println(tile.getMonitor().getLastTile().getXPos() + " " + tile.getMonitor().getLastTile().getYPos());

                if(engine.getTurn() == color && check()){

                    int d = color ? -1 : 1;
                    tile.setFigure(null);

                    engine.getLastTile().setFigure(tmp);

                    engine.changeTurn();

                }

                picture.setVisible(true);

                chessboard.setMovingFigure(null,0,0);
                chessboard.repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public JLabel getPicture() {
        return picture;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    protected boolean check() {
        return false;
    }

    public boolean getColor(){
        return color;
    }
}
