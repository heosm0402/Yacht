package com.smheo.YachtGame;

public class GameController {
    private int round = 0;

    public void run() {
        NewPlayer p1 = new NewPlayer();
        p1.setPlayerNumber(1);
        NewPlayer p2 = new NewPlayer();
        p2.setPlayerNumber(2);

        while (this.round < 12) {
            System.out.println("[GAME INFO] ROUND" + this.round);
            p1.turn();
            p2.turn();
            System.out.println("[GAME INFO] TOTAL SCORE P1:" + p1.getTotalScore() +
                    " | P2:" + p2.getTotalScore());
            this.round += 1;
        }
    }
}
