package kretowicz.app;

import kretowicz.engine.Engine;
import kretowicz.figures.Pawn;
import kretowicz.gui.GUI;

public class Chess {
    public static void main(String [] args) {
        GUI gui = new GUI();
        Engine engine = new Engine(gui.getChessboard());

        engine.startGame();

        gui.show();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pawn pawn = engine.getWhitePawns()[3];
        pawn.moveForwardLong();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(gui.getChessboard().monitor.getLastTile().getXPos() + " " + gui.getChessboard().monitor.getLastTile().getYPos());
    }
}
