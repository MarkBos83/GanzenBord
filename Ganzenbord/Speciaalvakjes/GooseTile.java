package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class GooseTile extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese) {

    }

    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        int newPosition;
        if (goose.back) {
            System.out.println(goose.position + ", een gans, ga nogmaals het aantal gegooide ogen terug");
            newPosition = goose.position - dice1 - dice2;
        } else {
            System.out.println(goose.position + ", een gans, ga nogmaals het aantal gegooide ogen verder");
            newPosition = goose.position + dice1 + dice2;
            if (newPosition > 63) {
                newPosition = 63 - (newPosition - 63);
                goose.back = true;
            }
        }
        goose.jailOrWellCheck(dice1, dice2, geese, board);
        if (!board.boardgame[newPosition].isOccupied) {
            goose.position = newPosition;
            board.boardgame[goose.position].execute(goose.position, goose, board, dice1, dice2, geese);
        } else {
            System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
            goose.position = goose.oldPosition;
        }
    }
}

