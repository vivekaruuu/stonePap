package com.example.stonepapsis.answercheck;

public class answerCheck {
    public static String check(int a, int b) {
        if (a == 1) {
            if (b == 1)
                return "draw";
            if (b == 2)
                return "Player 2 wins";
            if (b == 3)
                return "Player 1 wins";
        }
        if (a == 2) {
            if (b == 1)
                return "Player 1 wins";
            if (b == 2)
                return "draw";
            if (b == 3)
                return "Player 2 wins";
        }
        if (a == 3) {
            if (b == 1)
                return "Player 2 wins";
            if (b == 2)
                return "Player 1 wins";
            if (b == 3)
                return "draw";
        }
        return null;
    }

}
