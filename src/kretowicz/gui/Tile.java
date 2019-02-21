package kretowicz.gui;

import kretowicz.engine.Engine;
import kretowicz.figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel {
    private Figure figure;
    private Color color;
    private int x,y;

    private Engine engine;

    public Tile(Color color, int x,int y, Engine engine) {
        this.color = color;
        this.x = x;
        this.y = y;

        this.engine = engine;

        setBackground(color);

        ///////////////////////////////////////////

        Tile tmp = this;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }



            @Override
            public void mouseEntered(MouseEvent e) {
                engine.setLastTile(tmp);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


    }

    public void setFigure(Figure figure) {

        if(this.figure != null)
            remove(this.figure.getPicture());

        if(figure != null) {
            add(figure.getPicture());
            figure.setTile(this);
        }

        this.figure = figure;
        repaint();
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public Engine getEngine() {
        return engine;
    }
}
