package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;


public class Pawn extends Figure {

    private boolean firstMove;

    public Pawn(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard,engine);
        firstMove = true;
    }

    @Override
    public boolean check() {
        boolean result =
                moveForward() ||
                moveForwardLong() ||
                moveForwardRight() ||
                moveForwardLeft();

        if(result)
            firstMove = false;
        return result;
    }

    public boolean moveForward() {
        int d = color ? -1 : 1;
        if(tile.getXPos() == engine.getLastTile().getXPos() - d && tile.getYPos() == engine.getLastTile().getYPos() &&
                engine.getLastTile().getFigure() == null)
            return true;
        return false;
    }

    public boolean moveForwardLong() {
        int d = color ? -1 : 1;

        if(!firstMove)
            return false;

        if(chessboard.getTile(tile.getXPos() + d, tile.getYPos()).getFigure() != null)
            return false;

        if(chessboard.getTile(tile.getXPos() + 2*d, tile.getYPos()).getFigure() != null)
            return false;

        if(engine.getTurn() == color && tile.getXPos() == engine.getLastTile().getXPos() - 2*d && tile.getYPos() == engine.getLastTile().getYPos()) {
            return true;
        }
        return false;
    }

    public boolean moveForwardRight() {
        int d = color ? -1 : 1;
        if(tile.getXPos() == engine.getLastTile().getXPos() - d && tile.getYPos() == engine.getLastTile().getYPos() + d &&
                engine.getLastTile().getFigure()!= null) {
            return true;
        }
        return false;
    }

    public boolean moveForwardLeft() {
        int d = color ? -1 : 1;
        if(tile.getXPos() == engine.getLastTile().getXPos() - d && tile.getYPos() == engine.getLastTile().getYPos() - d &&
                engine.getLastTile().getFigure()!= null)
            return true;
        return false;
    }


}
