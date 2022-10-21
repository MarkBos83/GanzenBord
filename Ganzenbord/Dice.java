package Ganzenbord;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    final int sidesOfDice = 6;

    int throwDice() {
        return 1 + random.nextInt(sidesOfDice);
    }
}