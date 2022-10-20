package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Begin {
    int aantalspelers;

    void spelersmaken(Scanner scanner, ArrayList<Gans> ganzen) {
        do {
            System.out.print("Met Hoeveel Spelers wil je spelen (tussen 2 en 6): ");
            aantalspelers = scanner.nextInt();
            scanner.nextLine();
        } while (aantalspelers < 2 || aantalspelers > 6);
        System.out.println("Vul de kleuren of namen van de spelers in (druk op enter na elke ingevulde naam): ");
        for (int i = 0; i < aantalspelers; i++) {
            String naam;
            boolean dubbeleNaam;
            do {
                dubbeleNaam = false;
                naam = scanner.nextLine();
                for (Gans g : ganzen) {
                    if (g.naam.equalsIgnoreCase(naam)) {
                        dubbeleNaam = true;
                        break;
                    }
                }
                if (dubbeleNaam) {
                    System.out.println("die kleur/naam is al in gebruik, kies een andere: ");
                }
            } while (dubbeleNaam || naam.length() == 0);
            ganzen.add(i, new Gans(naam));
        }
    }

    void beginnen(ArrayList<Gans> ganz, ArrayList<Gans> ganzen, Scanner scanner, Dobbelsteen dob1, Dobbelsteen dob2, Bord bord) {
        do {
            ganz = hoogstgegooid(ganz, scanner, dob1);
        } while (ganz.size() != 1);
        switch (ganzen.indexOf(ganz.get(0))) {
            case 0:
                ganzen.get(0).beurt(scanner, dob1, dob2, bord, ganzen.get(0), ganzen);
            case 1:
                ganzen.get(1).beurt(scanner, dob1, dob2, bord, ganzen.get(1), ganzen);
            case 2:
                if (aantalspelers > 2) {
                    ganzen.get(2).beurt(scanner, dob1, dob2, bord, ganzen.get(2), ganzen);
                }
            case 3:
                if (aantalspelers > 3) {
                    ganzen.get(3).beurt(scanner, dob1, dob2, bord, ganzen.get(3), ganzen);
                }
            case 4:
                if (aantalspelers > 4) {
                    ganzen.get(4).beurt(scanner, dob1, dob2, bord, ganzen.get(4), ganzen);
                }
            case 5:
                if (aantalspelers > 5) {
                    ganzen.get(5).beurt(scanner, dob1, dob2, bord, ganzen.get(5), ganzen);
                }
        }
    }

    private ArrayList<Gans> hoogstgegooid(ArrayList<Gans> ganzen, Scanner scanner, Dobbelsteen dob1) {
        int hoogste = 0;
        ArrayList<Gans> hoogsteGanzen = new ArrayList<>();

        for (Gans gans : ganzen) {
            System.out.print(gans.naam + ", druk op enter om 1 dobbelsteen te gooien");
            scanner.nextLine();
            int dobbel1 = dob1.Gooien();
            System.out.println("Je hebt " + dobbel1 + " gegooid\n");
            if (dobbel1 > hoogste) {
                hoogsteGanzen.clear();
                hoogste = dobbel1;
                hoogsteGanzen.add(gans);
            } else if (dobbel1 == hoogste) {
                hoogsteGanzen.add(gans);
            }
        }
        if (hoogsteGanzen.size() > 1) {
            System.out.println("meerdere spelers hebben het hoogst gegooid, die spelers gooien nu opnieuw.");
        }
        return hoogsteGanzen;
    }
}
