package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class Teleport extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese) {

    }

    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        if (goose.position == 6) {
            System.out.println("Je komt op " + goose.position + ", een brug! ga verder naar 12");
            int newPosition = 12;
            if (!board.boardgame[newPosition].isOccupied) {
                goose.position = newPosition;
            } else {
                System.out.println("Je komt op " + newPosition + ", dit vakje is al bezet, je gaat terug naar je oude plek");
                goose.position = goose.oldPosition;
            }
        } else if (goose.position == 42) {
            System.out.println("Je komt op " + goose.position + ", AAAAHH!! doornstruik! ga terug naar 37");
            int newPosition = 37;
            if (!board.boardgame[newPosition].isOccupied) {
                goose.position = newPosition;
            } else {
                System.out.println("Je komt op " + newPosition + ", dit vakje is al bezet, je gaat terug naar je oude plek");
                goose.position = goose.oldPosition;
            }
        } else if (goose.position == 58) {
            System.out.println("Je komt op " + goose.position + ", je bent dood, ga terug naar de start");
            goose.position = 0;
        }
    }
}