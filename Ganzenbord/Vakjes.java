package Ganzenbord;

import java.util.ArrayList;

public abstract class Vakjes {

    public boolean isBezet;

    public abstract void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen);
    public abstract void onPass(ArrayList<Gans> ganzen);
}