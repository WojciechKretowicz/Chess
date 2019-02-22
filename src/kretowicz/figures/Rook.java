package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;

public class Rook extends Figure {
    public Rook(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard, engine);

    }

    @Override
    protected boolean check() {
        boolean result =
                moveVertically() ||
                        moveHorizontally();

        return result;
    }

    private boolean moveVertically() {
        if (tile.getYPos() != engine.getLastTile().getYPos())
            return false;

        if (tile.getXPos() == engine.getLastTile().getXPos())
            return false;

        if (tile.getXPos() < engine.getLastTile().getXPos()) {
            for (int i = tile.getXPos() + 1; i < engine.getLastTile().getXPos(); i++)
                if (chessboard.getTile(i, tile.getYPos()).getFigure() != null)
                    return false;
        } else {
            for (int i = tile.getXPos() - 1; i > engine.getLastTile().getXPos(); i--)
                if (chessboard.getTile(i, tile.getYPos()).getFigure() != null)
                    return false;
        }

        if (engine.getLastTile().getFigure() != null &&
                engine.getLastTile().getFigure().color == color)
            return false;

        return true;
    }

    private boolean moveHorizontally() {
        if (tile.getXPos() != engine.getLastTile().getXPos())
            return false;

        if (tile.getYPos() == engine.getLastTile().getYPos())
            return false;

        if (tile.getYPos() < engine.getLastTile().getYPos()) {
            for (int i = tile.getYPos() + 1; i < engine.getLastTile().getYPos(); i++)
                if (chessboard.getTile(tile.getXPos(), i).getFigure() != null)
                    return false;
        } else {
            for (int i = tile.getYPos() - 1; i > engine.getLastTile().getYPos(); i--)
                if (chessboard.getTile(tile.getXPos(), i).getFigure() != null)
                    return false;
        }

        if (engine.getLastTile().getFigure() != null &&
                engine.getLastTile().getFigure().color == color)
            return false;

        return true;
    }
}
