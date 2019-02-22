package kretowicz.engine;

import kretowicz.figures.*;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

public class Engine {
    private Chessboard chessboard;

    private Pawn [] whitePawns;
    private Pawn [] blackPawns;

    private Knight [] whiteKnights;
    private Knight [] blackKnights;

    private Rook [] whiteRooks;
    private Rook [] blackRooks;

    private Bishop [] whiteBishops;
    private Bishop [] blackBishops;

    private King whiteKing;
    private King blackKing;

    private Queen whiteQueen;
    private Queen blackQueen;

    private boolean turn;

    private Tile lastTile;

    private boolean whiteKingCheck;
    private boolean blackKingCheck;


    public Engine() {
        turn = true;
        whiteKingCheck = false;
        blackKingCheck = false;
    }

    public void setChessboard(Chessboard chessboard) {
        this.chessboard = chessboard;

        whitePawns = new Pawn[8];
        blackPawns = new Pawn[8];

        whiteKnights = new Knight[2];
        blackKnights = new Knight[2];

        whiteRooks = new Rook[2];
        blackRooks = new Rook[2];

        whiteBishops = new Bishop[2];
        blackBishops = new Bishop[2];


        for(int i=0; i<8; i++)
            whitePawns[i] = new Pawn(true, chessboard, this);

        for(int i=0; i<8; i++)
            blackPawns[i] = new Pawn(false, chessboard, this);

        whiteKnights[0] = new Knight(true, chessboard, this);
        whiteKnights[1] = new Knight(true,chessboard, this);

        blackKnights[0] = new Knight(false,chessboard, this);
        blackKnights[1] = new Knight(false,chessboard, this);

        whiteRooks[0] = new Rook(true,chessboard, this);
        whiteRooks[1] = new Rook(true,chessboard, this);

        blackRooks[0] = new Rook(false,chessboard, this);
        blackRooks[1] = new Rook(false,chessboard, this);

        whiteBishops[0] = new Bishop(true,chessboard, this);
        whiteBishops[1] = new Bishop(true,chessboard, this);

        blackBishops[0] = new Bishop(false,chessboard, this);
        blackBishops[1] = new Bishop(false,chessboard, this);

        whiteKing = new King(true,chessboard, this);

        blackKing = new King(false,chessboard, this);

        whiteQueen = new Queen(true,chessboard, this);

        blackQueen = new Queen(false,chessboard, this);
    }

    public void startGame() {

        // placing pawns
        for(int i=0; i<8; i++) {
            chessboard.getTile(6,i).setFigure(whitePawns[i]);
            chessboard.getTile(6,i).showFigure();

            chessboard.getTile(1,i).setFigure(blackPawns[i]);
            chessboard.getTile(1,i).showFigure();
        }

        chessboard.getTile(0,0).setFigure(blackRooks[0]);
        chessboard.getTile(0,0).showFigure();
        chessboard.getTile(0,7).setFigure(blackRooks[1]);
        chessboard.getTile(0,7).showFigure();
        chessboard.getTile(0,1).setFigure(blackKnights[0]);
        chessboard.getTile(0,1).showFigure();
        chessboard.getTile(0,6).setFigure(blackKnights[1]);
        chessboard.getTile(0,6).showFigure();
        chessboard.getTile(0,2).setFigure(blackBishops[0]);
        chessboard.getTile(0,2).showFigure();
        chessboard.getTile(0,5).setFigure(blackBishops[1]);
        chessboard.getTile(0,5).showFigure();
        chessboard.getTile(0,3).setFigure(blackQueen);
        chessboard.getTile(0,3).showFigure();
        chessboard.getTile(0,4).setFigure(blackKing);
        chessboard.getTile(0,4).showFigure();

        chessboard.getTile(7,0).setFigure(whiteRooks[0]);
        chessboard.getTile(7,0).showFigure();
        chessboard.getTile(7,7).setFigure(whiteRooks[1]);
        chessboard.getTile(7,7).showFigure();
        chessboard.getTile(7,1).setFigure(whiteKnights[0]);
        chessboard.getTile(7,1).showFigure();
        chessboard.getTile(7,6).setFigure(whiteKnights[1]);
        chessboard.getTile(7,6).showFigure();
        chessboard.getTile(7,2).setFigure(whiteBishops[0]);
        chessboard.getTile(7,2).showFigure();
        chessboard.getTile(7,5).setFigure(whiteBishops[1]);
        chessboard.getTile(7,5).showFigure();
        chessboard.getTile(7,3).setFigure(whiteQueen);
        chessboard.getTile(7,3).showFigure();
        chessboard.getTile(7,4).setFigure(whiteKing);
        chessboard.getTile(7,4).showFigure();
    }


    public King getKing(boolean color) {
        return color ? whiteKing : blackKing;
    }

    public boolean getTurn() {
        return turn;
    }

    public void changeTurn() {
        turn = !turn;
    }

    public Tile getLastTile() {
        return lastTile;
    }

    public void setLastTile(Tile lastTile) {
        this.lastTile = lastTile;
    }

    public boolean check(boolean color, Tile tile) {
        int x = tile.getXPos();
        int y = tile.getYPos();

        Figure tmp;

        ////////////////////////////////////

        for(int i = x-1; i>=0; i--) {

            tmp = chessboard.getTile(i,y).getFigure();
            if(tmp != null) {
                if(tmp.getColor() != color &&
                        (tmp instanceof Rook ||
                        tmp instanceof Queen))
                    return true;
                break;
            }
        }
        //System.out.println(1);
        for(int i = x+1; i<8; i++) {

            tmp = chessboard.getTile(i,y).getFigure();
            if(tmp != null) {
                if(tmp.getColor() != color &&
                        (tmp instanceof Rook ||
                                tmp instanceof Queen))
                    return true;
                break;
            }
        }
        //System.out.println(2);
        //////////////////////////////

        for(int i = y-1; i>=0; i--) {

            tmp = chessboard.getTile(x,i).getFigure();
            if(tmp != null) {
                if(tmp.getColor() != color &&
                        (tmp instanceof Rook ||
                                tmp instanceof Queen))
                    return true;
                break;
            }
        }
        //System.out.println(3);
        for(int i = y+1; i<8; i++) {

            tmp = chessboard.getTile(x,i).getFigure();
            if(tmp != null) {
                if(tmp.getColor() != color &&
                        (tmp instanceof Rook ||
                                tmp instanceof Queen))
                    return true;
                break;
            }
        }
        //System.out.println(4);
        ////////////////////////////////

        if(skew(color,tile,1,1) ||
                skew(color,tile,1,-1) ||
                skew(color,tile,-1,1) ||
                skew(color,tile,-1,-1))
            return true;

        //System.out.println(5);
        /////////////////////////////////////

        if(kingAlert(color,tile,1,0) ||
                kingAlert(color,tile,-1,0) ||
                kingAlert(color,tile,0,1) ||
                kingAlert(color,tile,0,-1))
            return true;

        //System.out.println(6);
        /////////////////////////////////////////

        return false;

    }

    private boolean skew(boolean color, Tile tile, int di, int dj) {
        int x = tile.getXPos();
        int y = tile.getYPos();

        Figure tmp;

        for(int i = x+di, j = y + dj; i>=0 && i<8 && j >=0 && j<8; i+=di, j+=dj) {

            tmp = chessboard.getTile(i,j).getFigure();
            if(tmp != null) {
                if(tmp.getColor() != color &&
                        (tmp instanceof Bishop ||
                                tmp instanceof Queen)) {
                    return true;
                }
                break;
            }
        }

        return false;
    }

    private boolean kingAlert(boolean color, Tile tile, int di, int dj) {
        int x = tile.getXPos();
        int y = tile.getYPos();

        if(x+di<0 || x+di>=8 || y+dj<0 || y+dj >=8)
            return false;

        Figure tmp = chessboard.getTile(x+di,y+dj).getFigure();
        if(tmp != null &&
                tmp.getColor() != color && tmp instanceof King)
            return true;

        return false;
    }

    public void changeKingCheck(boolean color) {
        if(color)
            this.whiteKingCheck = !this.whiteKingCheck;
        else
            this.blackKingCheck = !this.blackKingCheck;
    }

    public boolean getKingCheck(boolean color) {
        if(color)
            return this.whiteKingCheck;
        else
            return this.blackKingCheck;
    }



}
