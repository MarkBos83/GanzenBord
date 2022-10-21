package Ganzenbord;

import Ganzenbord.Speciaalvakjes.*;

import java.util.ArrayList;

public class Board {
    public Squares[] boardgame = new Squares[64];

    void makeBoard() {
        for (int i = 0; i < boardgame.length; i++) {
            boardgame[i] = new Default();
        }
        boardgame[6] = new Teleport();
        boardgame[9] = new Nine();
        boardgame[19] = new Inn();
        boardgame[31] = new Well();
        boardgame[42] = new Teleport();
        boardgame[52] = new Jail();
        boardgame[58] = new Teleport();
        for (int i = 5; i < 60; i += 5) {
            boardgame[i] = new GooseTile();
            i += 4;
            if (i == 9) {
                continue;
            }
            if (i < 60) {
                boardgame[i] = new GooseTile();
            }
        }
    }

    void printBoard(ArrayList<Goose> geese, Goose goose) {
        int[][] playBoard = {
                {29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19},
                {30, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18},
                {31, -1, 55, 54, 53, 52, 51, 50, 49, -1, 17},
                {32, -1, 56, -1, -1, -1, -1, -1, 48, -1, 16},
                {33, -1, 57, -1, -1, -1, 63, -1, 47, -1, 15},
                {34, -1, 58, 59, 60, 61, 62, -1, 46, -1, 14},
                {35, -1, -1, -1, -1, -1, -1, -1, 45, -1, 13},
                {36, 37, 38, 39, 40, 41, 42, 43, 44, -1, 12},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                int game = playBoard[i][j];
                String typeOfTile = switch (game) {
                    case 0 -> "[ST]";
                    case 5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59 -> "[GO]";
                    case 6 -> "[BR]";
                    case 19 -> "[IN]";
                    case 31 -> "[WE]";
                    case 42 -> "[TH]";
                    case 52 -> "[JA]";
                    case 58 -> "[DE]";
                    case -1 -> "    ";
                    case 1, 2, 3, 4, 7, 8 -> "[ " + game + "]";
                    case 63 -> "[FI]";
                    default -> "[" + game + "]";
                };
                for (Goose g : geese) {
                    if (game == g.position) {
                        typeOfTile = g.colorCode + typeOfTile + "\u001B[0m";
                    }
                }
                System.out.print(typeOfTile);
            }
            System.out.println();
        }
    }
}