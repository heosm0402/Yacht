package com.smheo.YachtGame;


public class GameController {
    private int round = 1;
    private int roundScore = 0;
    public void run() {
        GamePlayer p1 = new GamePlayer();
        p1.setPlayerNumber(1);
        GamePlayer p2 = new GamePlayer();
        p2.setPlayerNumber(2);
        ScoreCalculator scoreCalculator = new ScoreCalculator();

        while (this.round < 13) {
            System.out.println();
            System.out.println("========================================================================== [" + "\t\t" + "ROUND " + "\t" + this.round + "\t\t" + " ] ================================================================");
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

    private void setScore(GamePlayer p, int score) {

        // TODO: change to while loop (while !hashmap.containsKey(rank))
        if (!(p.getScoreTable().containsKey(p.getRank()))) {
            p.getScoreTable().put(p.getRank(), score);
            System.out.println("[GAME INFO] PLAYER " + p.getPlayerNumber() + " SCORE: " + roundScore);
        } else {
            System.out.println("[GAME INFO] PLAYER " + p.getPlayerNumber() + " ALREADY HAVE RANK [" + p.getRank() + "]");
        }
    }

    private int getTotalScore(GamePlayer gamePlayer) {
        int totalScore = 0;
            for (String strKey : gamePlayer.getScoreTable().keySet()) {
                totalScore += gamePlayer.getScoreTable().get(strKey);

            }

        return totalScore;
    }

    private int getSubTotal(GamePlayer gamePlayer) {
        int subTotal = 0;
        for (int i = 0; i < 6; i++) {
            if (gamePlayer.getScoreTable().containsKey(Integer.toString(i+1))){
                subTotal += gamePlayer.getScoreTable().get(Integer.toString(i+1));
            }
        }

        if (subTotal >= 63) {
            gamePlayer.setRank("B");
            setScore(gamePlayer, 35);
        }
        return subTotal;
    }

    private int isHaveBonus(GamePlayer gamePlayer) {
        return gamePlayer.getScoreTable().getOrDefault("B", 0);
    }

    private void showRoundSummary(GamePlayer p1, GamePlayer p2) {
        System.out.println("=============================================================== [" + "\t\t" + "ROUND " + "\t" + this.round + "\t\t" + " SUMMARY"  + "\t\t" + "] =============================================================");
        System.out.println("PLAYER 1" + "\t" + " | TOTAL SCORE " + getTotalScore(p1) + "\t" + " | " + "\t" + "SCORE BOARD "+ p1.roundSummary() + "\t\t" + " | " + "\t\t" + "SUBTOTAL " + getSubTotal(p1) + "/63" + "\t" + " | " + "\t" + "BONUS " + isHaveBonus(p1));
        System.out.println("PLAYER 2" + "\t" + " | TOTAL SCORE " + getTotalScore(p2) + "\t" + " | " + "\t" + "SCORE BOARD "+ p2.roundSummary() + "\t\t" + " | " + "\t\t" + "SUBTOTAL " + getSubTotal(p2) + "/63" + "\t" + " | " + "\t" + "BONUS " + isHaveBonus(p2));
        System.out.println("=======================================================================================================================================================================");
    }

    private void gameResult(GamePlayer p1, GamePlayer p2) {
        if (getTotalScore(p1) > getTotalScore(p2)) {
            System.out.println("Player 1 win");
        } else if (getTotalScore(p1) < getTotalScore(p2)) {
            System.out.println("Player 2 win");
        } else {
            System.out.println("Wow draw game");
        }
    }
}
