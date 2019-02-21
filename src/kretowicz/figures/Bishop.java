package kretowicz.figures;

import kretowicz.engine.Engine;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;


public class Bishop extends Figure {
    public Bishop(boolean color, Chessboard chessboard, Engine engine) {
        super(color, chessboard, engine);

    }

    @Override
    protected boolean check() {
        if(this == engine.getLastTile().getFigure())
            return false;

        if(Math.abs(tile.getXPos() - engine.getLastTile().getXPos()) !=
                Math.abs(tile.getYPos() - engine.getLastTile().getYPos()))
            return false;


        //////////////////////////////

        int di,dj;

        if(tile.getXPos() > engine.getLastTile().getXPos())
            di = -1;
        else
            di = 1;

        if(tile.getYPos() > engine.getLastTile().getYPos())
            dj = -1;
        else
            dj = 1;

        if (tile.getXPos() - engine.getLastTile().getXPos() == -di) {
            if (engine.getLastTile().getFigure() != null &&
                    engine.getLastTile().getFigure().color == color)
                return false;
            return true;
        }

        for(int k=0; k<Math.abs(tile.getXPos() - engine.getLastTile().getXPos()); k ++) {
            int i = tile.getXPos() + di, j = tile.getYPos() + dj;
            if (chessboard.getTile(i, j).getFigure() != null)
                return false;
            i+=di;
            j+=dj;
        }


        if(engine.getLastTile().getFigure() != null &&
                engine.getLastTile().getFigure().color == color)
            return false;

        return true;
    }

}
