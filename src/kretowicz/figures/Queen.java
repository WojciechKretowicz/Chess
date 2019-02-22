package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;

public class Queen extends Figure {
    public Queen(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard, engine);

    }

    @Override
    protected boolean check() {
        boolean result =
                moveHorizontally() ||
                        moveVertically() ||
                        moveSkew();
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

    private boolean moveSkew() {
        if (this == engine.getLastTile().getFigure())
            return false;

        if (Math.abs(tile.getXPos() - engine.getLastTile().getXPos()) !=
                Math.abs(tile.getYPos() - engine.getLastTile().getYPos()))
            return false;


        //////////////////////////////

        int di, dj;

        if (tile.getXPos() > engine.getLastTile().getXPos())
            di = -1;
        else
            di = 1;

        if (tile.getYPos() > engine.getLastTile().getYPos())
            dj = -1;
        else
            dj = 1;

        if (tile.getXPos() - engine.getLastTile().getXPos() == -di) {
            if (engine.getLastTile().getFigure() != null &&
                    engine.getLastTile().getFigure().color == color)
                return false;
            return true;
        }

        for (int k = 0; k < Math.abs(tile.getXPos() - engine.getLastTile().getXPos()); k++) {
            int i = tile.getXPos() + di, j = tile.getYPos() + dj;
            if (chessboard.getTile(i, j).getFigure() != null)
                return false;
            i += di;
            j += dj;
        }


        if (engine.getLastTile().getFigure() != null &&
                engine.getLastTile().getFigure().color == color)
            return false;

        return true;
    }
}
