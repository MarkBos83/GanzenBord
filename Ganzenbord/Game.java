package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Board board = new Board();
    Begin begin = new Begin();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Goose> geese = new ArrayList<>();
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    void start() {
        board.makeBoard();
        begin.makePlayers(scanner, geese);
        begin.starting(geese, geese, scanner, dice1, dice2, board);
        boolean gameDone = false;
        do {
            for (Goose g : geese) {
                if (!g.fallen && !g.inJail && !g.skipTurn) {
                    g.turn(scanner, dice1, dice2, board, g, geese);
                } else {
                    g.skipTurn = false;
                    System.out.println("\n" + g.colorCode + g.color + " moet deze beurt overslaan.\n" + "\u001B[0m");
                    System.out.println("\u001B[34m" + "----------------------------------------------------------------------------" + "\u001B[0m");
                }
                if (g.position == 63) {
                    System.out.println("\n" + g.colorCode + g.color + " heeft gewonnen!");
                    gameDone = true;
                    break;
                }
            }
        } while (!gameDone);
    }
}