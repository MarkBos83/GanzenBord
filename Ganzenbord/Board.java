package Ganzenbord;

import Ganzenbord.Speciaalvakjes.*;

public class Board {
    public Squares[] boardgame = new Squares[64];

    void makeBoard() {
        for (int i = 0; i < boardgame.length; i++) {
            boardgame[i] = new Default();
        }
        boardgame[6] = new Teleport();
        boardgame[9] = new Nine();
        boardgame[19] = new Inn();
        boardgame[31] = new Well();
        boardgame[42] = new Teleport();
        boardgame[52] = new Jail();
        boardgame[58] = new Teleport();
        for (int i = 5; i < 60; i += 5) {
            boardgame[i] = new GooseTile();
            i += 4;
            if(i==9){
                continue;
            }
            if (i < 60) {
                boardgame[i] = new GooseTile();
            }
        }

    }
}
