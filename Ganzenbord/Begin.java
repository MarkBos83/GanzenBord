package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Begin {
    int amountOfPlayers;

    void makePlayers(Scanner scanner, ArrayList<Goose> geese) {
        String color = "";
        String colorCode = "";
        do {
            System.out.print("Met Hoeveel Spelers wil je spelen (tussen 2 en 6): ");
            amountOfPlayers = scanner.nextInt();
            scanner.nextLine();
        } while (amountOfPlayers < 2 || amountOfPlayers > 6);
        for (int i = 0; i < amountOfPlayers; i++) {
            switch (i) {
                case 0 -> {
                    color = "CYAAN";
                    colorCode = "\u001B[36m";
                }
                case 1 -> {
                    color = "ROOD";
                    colorCode = "\u001B[31m";
                }
                case 2 -> {
                    color = "GEEL";
                    colorCode = "\u001B[33m";
                }
                case 3 -> {
                    color = "ZWART";
                    colorCode = "\u001B[30m";
                }
                case 4 -> {
                    color = "PAARS";
                    colorCode = "\u001B[35m";
                }
                case 5 -> {
                    color = "GROEN";
                    colorCode = "\u001B[32m";
                }
                default -> {
                }
            }
            ;
            geese.add(i, new Goose(color, colorCode));
        }
    }

    void starting(ArrayList<Goose> gooz, ArrayList<Goose> geese, Scanner scanner, Dice dice1, Dice dice2, Board board) {
        do {
            gooz = highestThrownDice(gooz, scanner, dice1);
        } while (gooz.size() != 1);
        switch (geese.indexOf(gooz.get(0))) {
            case 0:
                geese.get(0).turn(scanner, dice1, dice2, board, geese.get(0), geese);
            case 1:
                geese.get(1).turn(scanner, dice1, dice2, board, geese.get(1), geese);
            case 2:
                if (amountOfPlayers > 2) {
                    geese.get(2).turn(scanner, dice1, dice2, board, geese.get(2), geese);
                }
            case 3:
                if (amountOfPlayers > 3) {
                    geese.get(3).turn(scanner, dice1, dice2, board, geese.get(3), geese);
                }
            case 4:
                if (amountOfPlayers > 4) {
                    geese.get(4).turn(scanner, dice1, dice2, board, geese.get(4), geese);
                }
            case 5:
                if (amountOfPlayers > 5) {
                    geese.get(5).turn(scanner, dice1, dice2, board, geese.get(5), geese);
                }
        }
    }

    private ArrayList<Goose> highestThrownDice(ArrayList<Goose> geese, Scanner scanner, Dice dice1) {
        int highest = 0;
        ArrayList<Goose> highestGeese = new ArrayList<>();
        System.out.println("Wie het hoogste gooit, begint.");
        for (Goose goose : geese) {
            System.out.print(goose.colorCode + goose.color + ", druk op enter om 1 dobbelsteen te gooien");
            scanner.nextLine();
            int thrown1 = dice1.throwDice();
            System.out.println("Je hebt " + thrown1 + " gegooid\n");
            if (thrown1 > highest) {
                highestGeese.clear();
                highest = thrown1;
                highestGeese.add(goose);
            } else if (thrown1 == highest) {
                highestGeese.add(goose);
            }
            System.out.println("\u001B[34m" + "----------------------------------------------------------------------------" + "\u001B[0m");
        }
        if (highestGeese.size() > 1) {
            System.out.println("meerdere spelers hebben het hoogst gegooid, die spelers gooien nu opnieuw.");
        } else {
            System.out.println(highestGeese.get(0).color + " Heeft het hoogst gegooid en mag beginnen.\n");
        }
        return highestGeese;
    }
}