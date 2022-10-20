package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Bord;
import Ganzenbord.Gans;
import Ganzenbord.Vakjes;

import java.util.ArrayList;

public class Inn extends Vakjes {
    @Override
    public void onPass(ArrayList<Gans> ganzen){

    }
    @Override
    public void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen) {
        System.out.println(gans.positie + ", Herberg, sla 1 beurt over");
        gans.beurtOverslaan = true;
    }
}
