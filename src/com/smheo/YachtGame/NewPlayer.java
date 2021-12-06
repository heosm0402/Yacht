package com.smheo.YachtGame;

public class NewPlayer {
    private int playerNumber = 0;
    private int totalScore = 0;
    private int[] dicesArray = {0, 0, 0, 0, 0};
    private int rollDiceCount = 0;


    public int getRollDiceCount() {
        return rollDiceCount;
    }

    public void addRollDiceCount() {
        this.rollDiceCount++;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void turn() {
        while (rollDiceCount <3){
            System.out.println("[GAME INFO] PLAYER " + this.playerNumber + " TURN");
            rollDice();
            nextStep = chooseNextStep();
        }
    }

    private void rollDice() {
        this.addRollDiceCount();
        for (int i = 0; i < dicesArray.length; i++) {
            if (dicesArray[i] == 0) {
                double randomValue = Math.random();
                int intValue = (int) (randomValue * 6) + 1;
                dicesArray[i] = intValue;
            }
        }
    }
}
