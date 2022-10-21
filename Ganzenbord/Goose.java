package Ganzenbord;

import java.util.ArrayList;
import java.util.Scanner;

public class Goose {

    public Goose(String color, String colorCode) {
        this.color = color;
        this.colorCode = colorCode;
    }

    final String colorCode;
    public final String color;
    public int position;
    public int oldPosition;
    public boolean back;
    public boolean inJail;
    public boolean fallen;
    public boolean skipTurn;

    void turn(Scanner scanner, Dice dice1, Dice dice2, Board board, Goose goose, ArrayList<Goose> geese) {
        if (back) {
            back = false;
        }
        System.out.print(colorCode + color + "'s beurt, druk op enter om de dobbelstenen te werpen.");
        scanner.nextLine();
        oldPosition = position;
        board.boardgame[oldPosition].isOccupied = false;
        int thrown1 = dice1.throwDice();
        int thrown2 = dice2.throwDice();
        int newPosition = position + thrown1 + thrown2;
        if (newPosition > 63) {
            newPosition = 63 - (newPosition - 63);
            back = true;
        }
        jailOrWellCheck(thrown1, thrown2, geese, board);
        System.out.println("Je staat op " + goose.position + " en je hebt " + thrown1 + " en " + thrown2 + " gegooid (samen " + (thrown1 + thrown2) + ")");
        if (!board.boardgame[newPosition].isOccupied) {
            position = newPosition;
            board.boardgame[position].execute(position, goose, board, thrown1, thrown2, geese);
        } else {
            System.out.println("Je komt op " + newPosition + ", dit vakje is al bezet, je gaat terug naar je oude plek");
            position = oldPosition;
        }
        System.out.println("de positie van " + color + " is nu " + goose.position + "\n" + "\u001B[0m");
        board.boardgame[position].isOccupied = true;

        board.printBoard(geese, goose);
        System.out.println("\u001B[34m" + "----------------------------------------------------------------------------" + "\u001B[0m");
    }

    public void jailOrWellCheck(int thrown1, int thrown2, ArrayList<Goose> geese, Board board) {
        boolean backPass = false;
        int passPosition = position;
        for (int i = 0; i < (thrown1 + thrown2); i++) {
            if (passPosition >= 63) {
                backPass = true;
            }
            if (backPass) {
                passPosition--;
            } else {
                passPosition++;
            }
            board.boardgame[passPosition].onPass(geese);
        }
    }
}