package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class Jail extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese) {
        for (Goose g : geese) {
            if (g.inJail) {
                g.inJail = false;
                System.out.println("je bent " + g.color + " gepasseerd en hebt hem bevrijdt uit de gevangenis");
            }
        }
    }

    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        System.out.println("Je komt op " + goose.position + ", je zit in de gevangenis, wacht tot iemand je passeert om je eruit te helpen, als je laastste staat, sla 1 beurt over.");
        boolean last = true;
        for (Goose g : geese) {
            if (g.position < goose.position) {
                last = false;
                break;
            }
        }
        if (last) {
            goose.skipTurn = true;
        } else {
            goose.inJail = true;
        }
    }
}