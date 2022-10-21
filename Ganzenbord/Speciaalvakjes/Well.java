package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Board;
import Ganzenbord.Goose;
import Ganzenbord.Squares;

import java.util.ArrayList;

public class Well extends Squares {
    @Override
    public void onPass(ArrayList<Goose> geese) {
        for (Goose g : geese) {
            if (g.fallen) {
                g.fallen = false;
                System.out.println("je bent " + g.color + " gepasseerd en hebt hem bevrijdt uit de put");
            }
        }
    }

    @Override
    public void execute(int i, Goose goose, Board board, int dice1, int dice2, ArrayList<Goose> geese) {
        System.out.println("Je komt op " + goose.position + ", je bent in de put gevallen, wacht tot iemand je passeert om je eruit te helpen, als je laastste staat, sla 1 beurt over.");
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
            goose.fallen = true;
        }
    }
}