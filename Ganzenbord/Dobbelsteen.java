package Ganzenbord;

import java.util.Random;

public class Dobbelsteen {
    private static final Random random = new Random();
    final int aantalZijden = 6;

    int Gooien() {
        return 1 + random.nextInt(aantalZijden);
    }
}