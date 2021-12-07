package com.smheo.YachtGame;

import java.util.HashMap;
import java.util.Map;

public class ScoreCalculator {
    private String rank;
    private int score;

    public int[] getDiceArray() {
        return diceArray;
    }

    public void setDiceArray(int[] diceArray) {
        this.diceArray = diceArray;
    }

    private int[] diceArray;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public int calculateScore(String rank, int[] diceArray) {
        setRank(rank);
        setDiceArray(diceArray);

        switch (rank) {
            case "1":
                setScore(calcCount(1));
            case "2":
                setScore(calcCount(2));
            case "3":
                setScore(calcCount(3));
            case "4":
                setScore(calcCount(4));
            case "5":
                setScore(calcCount(5));
            case "6":
                setScore(calcCount(6));
            case "C":
                setScore(calcChoice());
            case "FC":
                setScore(calc4OfAKind());
            case "FH":
                setScore(calcFullHouse());
            case "SS":
                setScore(calcSmallStraight());
            case "BS":
                setScore(calcBigStraight());
            case "Y":
                setScore(calcYacht());
        }

        return this.score;
    }

    private int calcCount(int target) {
        int calculatedScore = 0;
        for (int i=0; i < this.diceArray.length; i++) {
            if (this.diceArray[i] == target) {
                calculatedScore += target;
            }
        }
        return calculatedScore;
    }

    private int calcChoice() {
        int calculatedScore = 0;
        for (int i=0; i < this.diceArray.length; i++) {
            calculatedScore += diceArray[i];
        }
        return calculatedScore;

    }

    private int calc4OfAKind() {
        Map<String, Integer> valueCountMap = countDiceValues();

    }

    private int calcFullHouse() {
        Map<String, Integer> valueCountMap = countDiceValues();

    }

    private int calcSmallStraight() {

        return 15;
    }

    private int calcBigStraight() {

        return 30;

    }

    private int calcYacht() {
        for (int i=0; i < this.diceArray.length; i++) {
            if (this.diceArray[i] != this.diceArray[i+1] ) {
                return 0;
            }
        }
        return 50;
    }

    private Map<String, Integer> countDiceValues() {
        Map<String, Integer> valueCountMap = new HashMap<>();
        for (int key : this.diceArray) {
            Integer numOccurrence = valueCountMap.get(Integer.toString(key));
            if (numOccurrence == null) {
                valueCountMap.put(Integer.toString(key), key);
            } else {
                valueCountMap.put(Integer.toString(key), numOccurrence++);
            }
        }
        return valueCountMap;
    }
}
