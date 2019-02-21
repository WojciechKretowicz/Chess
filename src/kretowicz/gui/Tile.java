package kretowicz.gui;

import kretowicz.Monitor.Monitor;
import kretowicz.figures.Figure;
import kretowicz.figures.King;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel {
    private Figure figure;
    private Color color;
    private int x,y;

    private Monitor monitor;

    public Tile(Color color, int x,int y, Monitor monitor) {
        this.color = color;
        this.x = x;
        this.y = y;

        this.monitor = monitor;

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
                monitor.setLastTile(tmp);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


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

    public Monitor getMonitor() {
        return monitor;
    }
}
