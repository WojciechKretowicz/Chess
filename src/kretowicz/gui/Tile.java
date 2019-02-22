package kretowicz.gui;

import kretowicz.engine.Engine;
import kretowicz.figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel {
    private Figure figure, checkFigure;
    private Color color;
    private int x, y;

    private boolean additionalFigure;

    private Engine engine;

    public Tile(Color color, int x, int y, Engine engine) {
        this.color = color;
        this.x = x;
        this.y = y;

        checkFigure = null;

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

    public void showFigure() {
        if (checkFigure != null) {
            remove(checkFigure.getPicture());
        }
        if (figure != null) {
            add(figure.getPicture());
        }

        repaint();
    }

    public void goBack() {
        figure = checkFigure;
        if (figure != null)
            figure.setTile(this);
        checkFigure = null;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {

        checkFigure = this.figure;
        if (figure != null) {
            figure.setTile(this);
        }

        this.figure = figure;
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

    public void returnColor() {
        setBackground(color);
        repaint();
    }

}
