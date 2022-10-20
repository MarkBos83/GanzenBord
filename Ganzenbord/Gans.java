package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Gans {
    public Gans(String naam) {
        this.naam = naam;
    }

    final String naam;
    public int positie;
    public int oudePositie;
    public boolean eerstebeurt = true;
    public boolean terug;
    public boolean gevangen;
    public boolean gevallen;
    public boolean beurtOverslaan;

    void beurt(Scanner scanner, Dobbelsteen dob1, Dobbelsteen dob2, Bord bord, Gans gans, ArrayList<Gans> ganzen) {
        if (terug) {
            terug = false;
        }
        System.out.print(naam + "'s beurt, druk op enter om de dobbelstenen te werpen.");
        scanner.nextLine();
        oudePositie = positie;
        bord.speelbord[oudePositie].isBezet = false;
        int dobbel1 = dob1.Gooien();
        int dobbel2 = dob2.Gooien();
        int nieuwePositie = positie + dobbel1 + dobbel2;
        if (nieuwePositie > 63) {
            nieuwePositie = 63 - (nieuwePositie - 63);
            terug = true;
        }
        gevangenisOfPutCheck(dobbel1, dobbel2, ganzen, bord);
        System.out.println("Je hebt " + dobbel1 + " en " + dobbel2 + " gegooid (samen " + (dobbel1 + dobbel2) + ")");
        if (!bord.speelbord[nieuwePositie].isBezet) {
            positie = nieuwePositie;
            bord.speelbord[positie].uitvoeren(positie, gans, bord, dobbel1, dobbel2, ganzen);
        } else {
            System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
            positie = oudePositie;
        }
        System.out.println("de positie van " + naam + " is nu " + gans.positie + "\n");
        bord.speelbord[positie].isBezet = true;

        if (eerstebeurt) {
            eerstebeurt = false;
        }
    }
    public void gevangenisOfPutCheck(int dobbel1, int dobbel2, ArrayList<Gans> ganzen, Bord bord){
        boolean terugPass = false;
        int passPositie = positie;
        for(int i = 0; i<(dobbel1+dobbel2);i++){
            if(passPositie>=63){
                terugPass = true;
            }
            if(terugPass){
                passPositie--;
            } else {
                passPositie++;
            }
            bord.speelbord[passPositie].onPass(ganzen);
        }
    }
}