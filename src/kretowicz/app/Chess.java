package kretowicz.app;

import kretowicz.engine.Engine;
import kretowicz.figures.Pawn;
import kretowicz.gui.GUI;

public class Chess {
    public static void main(String [] args) {
        Engine engine = new Engine();

        GUI gui = new GUI(engine);
        engine.setChessboard(gui.getChessboard());

        engine.startGame();

        gui.show();

    }
}
