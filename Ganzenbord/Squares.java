package Ganzenbord;

import java.util.ArrayList;

public abstract class Squares {

    public boolean isOccupied;

    public abstract void execute(int i, Goose goose, Board board, int thrown1, int thrown2, ArrayList<Goose> geese);

    public abstract void onPass(ArrayList<Goose> geese);
}