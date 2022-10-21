package Ganzenbord;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Scanner;

public class Goose {
    public Goose(String name) {
        this.name = name;
    }

    final String name;
    public int position;
    public int oldPosition;
    public boolean firstTurn = true;
    public boolean back;
    public boolean inJail;
    public boolean fallen;
    public boolean skipTurn;

    void turn(Scanner scanner, Dice dice1, Dice dice2, Board board, Goose goose, ArrayList<Goose> geese) {
        if (back) {
            back = false;
        }
        System.out.print(name + "'s beurt, druk op enter om de dobbelstenen te werpen.");
        scanner.nextLine();
        oldPosition = position;
        board.boardgame[oldPosition].isOccupied = false;
        int thrown1 = dice1.throwDice();
        int thrown2 = dice2.throwDice();
        int newPosition = position + thrown1 + thrown2;
        if (newPosition> 63) {
            newPosition = 63 - (newPosition - 63);
            back = true;
        }
        jailOrWellCheck(thrown1, thrown2, geese, board);
        System.out.println("Je hebt " + thrown1 + " en " + thrown2 + " gegooid (samen " + (thrown1 + thrown2) + ")");
        if (!board.boardgame[newPosition].isOccupied) {
            position = newPosition;
            board.boardgame[position].execute(position, goose, board, thrown1, thrown2, geese);
        } else {
            System.out.println("Dit vakje is al bezet, je gaat terug naar je oude plek");
            position = oldPosition;
        }
        System.out.println("de positie van " + name + " is nu " + goose.position + "\n");
        board.boardgame[position].isOccupied = true;

        if (firstTurn) {
            firstTurn = false;
        }
    }
    public void jailOrWellCheck(int thrown1, int thrown2, ArrayList<Goose> geese, Board board){
        boolean backPass = false;
        int passPosition = position;
        for(int i = 0; i<(thrown1+thrown2);i++){
            if(passPosition>=63){
                backPass = true;
            }
            if(backPass){
                passPosition--;
            } else {
                passPosition++;
            }
            board.boardgame[passPosition].onPass(geese);
        }
    }
}