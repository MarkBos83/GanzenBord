package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Spel {
    Bord bord = new Bord();
    Begin begin = new Begin();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Gans> ganzen = new ArrayList<>();
    Dobbelsteen dob1 = new Dobbelsteen();
    Dobbelsteen dob2 = new Dobbelsteen();

    void start() {
        bord.speelbordmaken();
        begin.spelersmaken(scanner, ganzen);
        begin.beginnen(ganzen, ganzen, scanner, dob1, dob2, bord);

        boolean spelAf = false;
        do {
            for (Gans g : ganzen) {
                if (!g.gevallen && !g.gevangen && !g.beurtOverslaan) {
                    g.beurt(scanner, dob1, dob2, bord, g, ganzen);
                } else {
                    g.beurtOverslaan = false;
                    System.out.println("\n" + g.naam + " moet deze beurt overslaan.\n");
                }
                if (g.positie == 63) {
                    System.out.println("\n\n\n" + g.naam + " heeft gewonnen!");
                    spelAf = true;
                    break;
                }
            }
        } while (!spelAf);
    }
}