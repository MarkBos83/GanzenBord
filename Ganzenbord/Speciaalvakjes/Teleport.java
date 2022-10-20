package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Bord;
import Ganzenbord.Gans;
import Ganzenbord.Vakjes;

import java.util.ArrayList;

public class Teleport extends Vakjes {
    @Override
    public void onPass(ArrayList<Gans> ganzen){

    }
    @Override
    public void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen) {
        if (gans.positie == 6) {
            System.out.println(gans.positie + ", een brug! ga verder naar 12");
            int nieuwePositie = 12;
            if (!bord.speelbord[nieuwePositie].isBezet) {
                gans.positie = nieuwePositie;
            } else {
                System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
                gans.positie = gans.oudePositie;
            }
        } else if (gans.positie == 42) {
            System.out.println(gans.positie + ", AAAAHH!! doornstruik! ga terug naar 37");
            int nieuwePositie = 37;
            if (!bord.speelbord[nieuwePositie].isBezet) {
                gans.positie = nieuwePositie;
            } else {
                System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
                gans.positie = gans.oudePositie;
            }
        } else if (gans.positie == 58) {
            System.out.println(gans.positie + ", je bent dood, ga terug naar de start");
            gans.positie = 0;
        }
    }
}
