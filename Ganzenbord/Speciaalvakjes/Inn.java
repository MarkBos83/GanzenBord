package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class Inn extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese){

    }
    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        System.out.println(goose.position + ", Herberg, sla 1 beurt over");
        goose.skipTurn = true;
    }
}
