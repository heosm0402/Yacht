package com.smheo.YachtGame;


public class GameController {
    private int round = 0;
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

            showRoundSummary(p1, p2);
            this.round += 1;
        }
        gameResult(p1, p2);
    }

    private void setScore(NewPlayer p, int score) {

        // TODO: change to while loop (while !hashmap.containsKey(rank))
        if (!(p.getScoreTable().containsKey(p.getRank()))) {
            p.getScoreTable().put(p.getRank(), score);
            System.out.println("player " + p.getPlayerNumber() + " score: " + roundScore);
        } else {
            System.out.println("player " + p.getPlayerNumber() + " already have rank [" + p.getRank() + "]");
        }
    }

    private int getTotalScore(NewPlayer player) {
        int totalScore = 0;
            for (String strKey : player.getScoreTable().keySet()) {
                totalScore += player.getScoreTable().get(strKey);

            }

        return totalScore;
    }

    private int getSubTotal(NewPlayer player) {
        int subTotal = 0;
        for (int i = 0; i < 6; i++) {
            if (player.getScoreTable().containsKey(Integer.toString(i+1))){
                subTotal += player.getScoreTable().get(Integer.toString(i+1));
            }
        }

        if (subTotal >= 63) {
            player.setRank("B");
            setScore(player, 35);
        }
        return subTotal;
    }

    private int isHaveBonus(NewPlayer player) {
        return player.getScoreTable().getOrDefault("B", 0);
    }

    private void showRoundSummary(NewPlayer p1, NewPlayer p2) {
        System.out.println("===================================[ROUND " + this.round +  "]====================================");
        System.out.println("TOTAL SCORE | Player 1: " + getTotalScore(p1) + " Player 2: " + getTotalScore(p2));
        System.out.println("Player 1 Score Board | " + p1.getScoreTable());
        System.out.println("Player 2 Score Board | " + p2.getScoreTable());
        System.out.println("================================================================================");

    }

    private void gameResult(NewPlayer p1, NewPlayer p2) {
        if (getTotalScore(p1) > getTotalScore(p2)) {
            System.out.println("Player 1 win");
        } else if (getTotalScore(p1) < getTotalScore(p2)) {
            System.out.println("Player 2 win");
        } else {
            System.out.println("Wow draw game");
        }
    }
}
