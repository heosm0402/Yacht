package com.smheo.YachtGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScoreCalculator {
    private String rank;
    private int score;
    private int[] diceArray;

    public int[] getDiceArray() {
        return diceArray;
    }

    public void setDiceArray(int[] diceArray) {
        this.diceArray = diceArray;
    }

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
                break;
            case "2":
                setScore(calcCount(2));
                break;
            case "3":
                setScore(calcCount(3));
                break;
            case "4":
                setScore(calcCount(4));
                break;
            case "5":
                setScore(calcCount(5));
                break;
            case "6":
                setScore(calcCount(6));
                break;
            case "C":
                setScore(calcChoice());
                break;
            case "FK":
                setScore(calc4OfAKind());
                break;
            case "FH":
                setScore(calcFullHouse());
                break;
            case "SS":
                setScore(calcSmallStraight());
                break;
            case "BS":
                setScore(calcBigStraight());
                break;
            case "Y":
                setScore(calcYacht());
                break;
        }

        return this.score;
    }

    private int calcCount(int target) {
        int calculatedScore = 0;
        for (int diceValue : this.diceArray) {
            if (diceValue == target) {
                calculatedScore += target;
            }
        }
        return calculatedScore;
    }

    private int calcChoice() {
        int calculatedScore = 0;
        for (int diceValue : this.diceArray) {
            calculatedScore += diceValue;
        }
        return calculatedScore;

    }

    private int calc4OfAKind() {
        Map<String, Integer> valueCountMap = countDiceValues();
        System.out.println(valueCountMap);
        int calculatedScore = 0;
        Integer[] toCheckValue = {4};

        for (String strKey: valueCountMap.keySet()) {
            if (Arrays.asList(toCheckValue).contains(valueCountMap.get(strKey))) {
                calculatedScore = Arrays.stream(this.diceArray).sum();
            }
        }
        return calculatedScore;
    }

    private int calcFullHouse() {
        Map<String, Integer> valueCountMap = countDiceValues();
        int calculatedScore = 0;
        Integer[] toCheckValue = {2, 3};


        for (String strKey : valueCountMap.keySet()) {
            if (!(Arrays.asList(toCheckValue).contains(valueCountMap.get(strKey)))) {
                return calculatedScore;
            }
        }
        return Arrays.stream(this.diceArray).sum();
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

            // TODO: replace with method 'merge'
            Integer numOccurrence = valueCountMap.get(Integer.toString(key));
            if (numOccurrence == null) {
                valueCountMap.put(Integer.toString(key), 1);
            } else {
                valueCountMap.put(Integer.toString(key), (numOccurrence +1));
            }
        }
        return valueCountMap;
    }
}
