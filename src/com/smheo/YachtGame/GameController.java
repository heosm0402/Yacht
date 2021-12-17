package com.smheo.YachtGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameController {
    private int round = 0;
    private Map<String, Integer> score_p1 = new HashMap<>();
    private Map<String, Integer> score_p2 = new HashMap<>();
    private int roundScore = 0;
    public void run() {
        NewPlayer p1 = new NewPlayer();
        p1.setPlayerNumber(1);
        NewPlayer p2 = new NewPlayer();
        p2.setPlayerNumber(2);
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        while (this.round < 12) {
            System.out.println("[GAME INFO] ROUND " + this.round);
            p1.turn();
            roundScore = scoreCalculator.calculateScore(p1.getRank(), p1.getDicesArray());
            setScore(p1, roundScore);

            p2.turn();
            roundScore = scoreCalculator.calculateScore(p2.getRank(), p2.getDicesArray());
            setScore(p2, roundScore);

            System.out.println("[GAME INFO] TOTAL SCORE P1:" + getTotalScore(p1) +
                    " | P2:" + getTotalScore(p2));
            System.out.println("==================================================");
            this.round += 1;
        }
    }

    private void setScore(NewPlayer p, int score) {

        // TODO: Refactoring
        if (p.getPlayerNumber() == 1) {
            // TODO: change to while loop (while !hashmap.containsKey(rank))
            if (!(this.score_p1.containsKey(p.getRank()))) {
                score_p1.put(p.getRank(), score);
                System.out.println("player " + p.getPlayerNumber() + " score: " + roundScore);
            } else {
                // TODO: rank reselect logic
                System.out.println("player " + p.getPlayerNumber() + " already have rank" + p.getRank());
            }
        } else {
            if(!(this.score_p2.containsKey(p.getRank()))) {
                score_p2.put(p.getRank(), score);
                System.out.println("player " + p.getPlayerNumber() + " score: " + roundScore);
            } else {
                System.out.println("player " + p.getPlayerNumber() + " already have rank" + p.getRank());
            }
        }
    }

    private int getTotalScore(NewPlayer p) {

        return 0;
    }

    private int getSubTotal(NewPlayer player) {

        return 0;
    }

    private void showRoundSummary() {

    }
}
