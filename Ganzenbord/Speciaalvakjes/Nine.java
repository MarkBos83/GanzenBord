package Ganzenbord.Speciaalvakjes;

import Ganzenbord.Bord;
import Ganzenbord.Gans;
import Ganzenbord.Vakjes;

import java.util.ArrayList;

public class Nine extends Vakjes {
    @Override
    public void onPass(ArrayList<Gans> ganzen){

    }
    @Override
    public void uitvoeren(int i, Gans gans, Bord bord, int dobbel1, int dobbel2, ArrayList<Gans> ganzen) {
        if (gans.eerstebeurt) {
            if (dobbel1 == 5 && dobbel2 == 4 || dobbel1 == 4 && dobbel2 == 5) {
                int nieuwePositie = 53;
                if (!bord.speelbord[nieuwePositie].isBezet) {
                    System.out.println("je hebt 5 en 4 gegooid, je mag direct door naar 53");
                    gans.positie = 53;
                } else {
                    System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
                    gans.positie = gans.oudePositie;
                }
            } else if (dobbel1 == 6 && dobbel2 == 3 || dobbel1 == 3 && dobbel2 == 6) {
                int nieuwePositie = 26;
                if (!bord.speelbord[nieuwePositie].isBezet) {
                    System.out.println("je hebt 6 en 3 gegooid, je mag direct door naar 26");
                    gans.positie = 26;
                } else {
                    System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
                    gans.positie = gans.oudePositie;
                }
            }
        } else {
            new GansTile().uitvoeren(0, gans, bord, dobbel1, dobbel2, ganzen);
        }
    }
}
