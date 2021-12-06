package com.smheo.YachtGame;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    private int round = 0;
    private Map<String, Integer> score_p1 = new HashMap<>();
    private Map<String, Integer> score_p2 = new HashMap<>();

    public void run() {
        NewPlayer p1 = new NewPlayer();
        p1.setPlayerNumber(1);
        NewPlayer p2 = new NewPlayer();
        p2.setPlayerNumber(2);

        while (this.round < 12) {
            System.out.println("[GAME INFO] ROUND " + this.round);
            p1.turn();
            p2.turn();
            System.out.println("[GAME INFO] TOTAL SCORE P1:" + getTotalScore(p1) +
                    " | P2:" + getTotalScore(p2));
            System.out.println("==================================================");
            this.round += 1;
        }
    }

    private void setScore(NewPlayer p1) {

    }

    private int getTotalScore(NewPlayer p1) {

        return 0;
    }
}
