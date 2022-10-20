package Ganzenbord;

import Ganzenbord.Speciaalvakjes.*;

public class Bord {
    public Vakjes[] speelbord = new Vakjes[64];

    void speelbordmaken() {
        for (int i = 0; i < speelbord.length; i++) {
            speelbord[i] = new Default();
        }
        speelbord[6] = new Teleport();
        speelbord[9] = new Nine();
        speelbord[19] = new Inn();
        speelbord[31] = new Well();
        speelbord[42] = new Teleport();
        speelbord[52] = new Jail();
        speelbord[58] = new Teleport();
        for (int i = 5; i < 60; i += 5) {
            speelbord[i] = new GansTile();
            i += 4;
            if(i==9){
                continue;
            }
            if (i < 60) {
                speelbord[i] = new GansTile();
            }
        }

    }
}
