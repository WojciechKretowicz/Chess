package kretowicz.engine;

import kretowicz.figures.*;
import kretowicz.gui.Chessboard;
import kretowicz.gui.Tile;

public class Engine {
    Chessboard chessboard;

    Pawn [] whitePawns;
    Pawn [] blackPawns;

    Knight [] whiteKnights;
    Knight [] blackKnights;

    Rook [] whiteRooks;
    Rook [] blackRooks;

    Bishop [] whiteBishops;
    Bishop [] blackBishops;

    King whiteKing;
    King blackKing;

    Queen whiteQueen;
    Queen blackQueen;


    public Engine(Chessboard chessboard) {
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
            whitePawns[i] = new Pawn(true, chessboard);

        for(int i=0; i<8; i++)
            blackPawns[i] = new Pawn(false, chessboard);

        whiteKnights[0] = new Knight(true, chessboard);
        whiteKnights[1] = new Knight(true,chessboard);

        blackKnights[0] = new Knight(false,chessboard);
        blackKnights[1] = new Knight(false,chessboard);

        whiteRooks[0] = new Rook(true,chessboard);
        whiteRooks[1] = new Rook(true,chessboard);

        blackRooks[0] = new Rook(false,chessboard);
        blackRooks[1] = new Rook(false,chessboard);

        whiteBishops[0] = new Bishop(true,chessboard);
        whiteBishops[1] = new Bishop(true,chessboard);

        blackBishops[0] = new Bishop(false,chessboard);
        blackBishops[1] = new Bishop(false,chessboard);

        whiteKing = new King(true,chessboard);

        blackKing = new King(false,chessboard);

        whiteQueen = new Queen(true,chessboard);

        blackQueen = new Queen(false,chessboard);
    }
    public void startGame() {

        // placing pawns
        for(int i=0; i<8; i++) {
            chessboard.getTile(6,i).setFigure(whitePawns[i]);

            chessboard.getTile(1,i).setFigure(blackPawns[i]);
        }

        chessboard.getTile(0,0).setFigure(blackRooks[0]);
        chessboard.getTile(0,7).setFigure(blackRooks[1]);
        chessboard.getTile(0,1).setFigure(blackKnights[0]);
        chessboard.getTile(0,6).setFigure(blackKnights[1]);
        chessboard.getTile(0,2).setFigure(blackBishops[0]);
        chessboard.getTile(0,5).setFigure(blackBishops[1]);
        chessboard.getTile(0,3).setFigure(blackQueen);
        chessboard.getTile(0,4).setFigure(blackKing);

        chessboard.getTile(7,0).setFigure(whiteRooks[0]);
        chessboard.getTile(7,7).setFigure(whiteRooks[1]);
        chessboard.getTile(7,1).setFigure(whiteKnights[0]);
        chessboard.getTile(7,6).setFigure(whiteKnights[1]);
        chessboard.getTile(7,2).setFigure(whiteBishops[0]);
        chessboard.getTile(7,5).setFigure(whiteBishops[1]);
        chessboard.getTile(7,3).setFigure(whiteQueen);
        chessboard.getTile(7,4).setFigure(whiteKing);
    }

    public Pawn[] getWhitePawns() {
        return whitePawns;
    }

    public Pawn[] getBlackPawns() {
        return blackPawns;
    }

    public Knight[] getWhiteKnights() {
        return whiteKnights;
    }

    public Knight[] getBlackKnights() {
        return blackKnights;
    }

    public Rook[] getWhiteRooks() {
        return whiteRooks;
    }

    public Rook[] getBlackRooks() {
        return blackRooks;
    }

    public Bishop[] getWhiteBishops() {
        return whiteBishops;
    }

    public Bishop[] getBlackBishops() {
        return blackBishops;
    }

    public King getWhiteKing() {
        return whiteKing;
    }

    public King getBlackKing() {
        return blackKing;
    }

    public Queen getWhiteQueen() {
        return whiteQueen;
    }

    public Queen getBlackQueen() {
        return blackQueen;
    }
}
