package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Bord;
import Ganzenbord.Gans;
import Ganzenbord.Vakjes;

import java.util.ArrayList;

public class GansTile extends Vakjes {
    @Override
    public void onPass(ArrayList<Gans> ganzen){

    }
    @Override
    public void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen) {
        int nieuwePositie;
        if (gans.terug) {
            System.out.println(gans.positie + ", een gans, ga nogmaals het aantal gegooide ogen terug");
            nieuwePositie = gans.positie - dobbel1 - dobbel2;
        } else {
            System.out.println(gans.positie + ", een gans, ga nogmaals het aantal gegooide ogen verder");
            nieuwePositie = gans.positie + dobbel1 + dobbel2;
            if (nieuwePositie > 63) {
                nieuwePositie = 63 - (nieuwePositie - 63);
                gans.terug = true;
            }
        }
        gans.gevangenisOfPutCheck(dobbel1, dobbel2, ganzen, bord);
        if (!bord.speelbord[nieuwePositie].isBezet) {
            gans.positie = nieuwePositie;
            bord.speelbord[gans.positie].uitvoeren(gans.positie, gans, bord, dobbel1, dobbel2, ganzen);
        } else {
            System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
            gans.positie = gans.oudePositie;
        }
    }
}
