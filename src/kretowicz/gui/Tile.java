package kretowicz.gui;

import kretowicz.figures.Figure;
import kretowicz.figures.King;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    private Figure figure;
    private Color color;
    private int x,y;

    public Tile(Color color, int x,int y) {
        this.color = color;
        this.x = x;
        this.y = y;

        setBackground(color);
    }

    public void setFigure(Figure figure) {

        if(figure != null) {
            add(figure.getPicture());
            figure.setTile(this);
        }
        else
            remove(this.figure.getPicture());

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
}
