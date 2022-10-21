package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class Nine extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese) {

    }

    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        if (goose.oldPosition == 0) {
            if (dice1 == 5 && dice2 == 4 || dice1 == 4 && dice2 == 5) {
                int newPosition = 53;
                if (!board.boardgame[newPosition].isOccupied) {
                    System.out.println("je hebt 5 en 4 gegooid, je mag direct door naar 53");
                    goose.position = 53;
                } else {
                    System.out.println("Je komt op " + newPosition + ", dit vakje is al bezet, je gaat terug naar je oude plek");
                    goose.position = goose.oldPosition;
                }
            } else if (dice1 == 6 && dice2 == 3 || dice1 == 3 && dice2 == 6) {
                int newPosition = 26;
                if (!board.boardgame[newPosition].isOccupied) {
                    System.out.println("je hebt 6 en 3 gegooid, je mag direct door naar 26");
                    goose.position = 26;
                } else {
                    System.out.println("Je komt op " + newPosition + ", dit vakje is al bezet, je gaat terug naar je oude plek");
                    goose.position = goose.oldPosition;
                }
            }
        } else {
            new GooseTile().execute(0, goose, board, dice1, dice2, geese);
        }
    }
}