package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Bord;
import Ganzenbord.Gans;
import Ganzenbord.Vakjes;

import java.util.ArrayList;

public class Jail extends Vakjes {
    @Override
    public void onPass(ArrayList<Gans> ganzen){
        for(Gans g: ganzen){
            if(g.gevangen){
                g.gevangen = false;
            }
        }
    }
    @Override
    public void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen) {
        System.out.println(gans.positie + ", je zit in de gevangenis, wacht tot iemand je passeert om je eruit te helpen, als je laastste staat, sla 1 beurt over.");
        boolean laatste = true;
        for (Gans g : ganzen) {
            if (g.positie < gans.positie) {
                laatste = false;
                break;
            }
        }
        if (laatste) {
            gans.beurtOverslaan = true;
        } else {
            gans.gevangen = true;
        }
    }
}
