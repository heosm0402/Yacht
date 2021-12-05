package com.smheo.Player;
import java.util.Scanner;


public class Player {
    private int totalScore = 0;
    private int ones = 0;
    private int twos = 0;
    private int threes = 0;
    private int fours = 0;
    private int fives = 0;
    private int sixes = 0;
    private int choice = 0;
    private int fourOfAKind = 0;
    private int fullHouse = 0;
    private int littleStraight = 0;
    private int bigStraight = 0;
    private int yacht = 0;
    private int[] dicesArray = new int[5];

    private String diceNumberToSave;
    private int[] savedDicesArray = new int[5];

    private void addToTotalScore(int score) {
        this.totalScore += score;
    }

    public void setOnes(int score) {
        if (this.ones == 0) {
            this.ones += score;
            addToTotalScore(this.ones);
        } else {
            System.out.println("ones is already done");
        }
    }

    public void setTwos(int score) {
        if (this.twos == 0) {
            this.twos += score;
            addToTotalScore(this.twos);
        } else {
            System.out.println("twos in already done");
        }
    }

    public void setThrees(int score) {
        if (this.threes == 0) {
            this.threes += score;
            addToTotalScore(this.threes);
        } else {
            System.out.println("threes in already done");
        }
    }

    public void setFours(int score) {
        if (this.fours == 0) {
            this.fours += score;
            addToTotalScore(this.fours);
        } else {
            System.out.println("fours in already done");
        }
    }

    public void setFives(int score) {
        if (this.fives == 0) {
            this.fives += score;
            addToTotalScore(this.fives);
        } else {
            System.out.println("fives in already done");
        }
    }

    public void setSixes(int score) {
        if (this.sixes == 0) {
            this.sixes += score;
            addToTotalScore(this.sixes);
        } else {
            System.out.println("sixes in already done");
        }
    }

    public void setChoice(int score) {
        if (this.choice == 0) {
            this.choice += score;
            addToTotalScore(this.choice);
        } else {
            System.out.println("choice in already done");
        }
    }

    public void setFourOfAKind(int score) {
        if (this.fourOfAKind == 0) {
            this.fourOfAKind += score;
            addToTotalScore(this.fourOfAKind);
        } else {
            System.out.println("four of a kind in already done");
        }
    }

    public void setFullHouse(int score) {
        if (this.fullHouse == 0) {
            this.fullHouse += score;
            addToTotalScore(this.fullHouse);
        } else {
            System.out.println("full house in already done");
        }
    }

    public void setLittleStraight(int score) {
        if (this.littleStraight == 0) {
            this.littleStraight += score;
            addToTotalScore(this.littleStraight);
        } else {
            System.out.println("little straight in already done");
        }
    }

    public void setBigStraight(int bigStraight) {
        if (this.bigStraight == 0) {
            this.bigStraight = bigStraight;
            addToTotalScore(this.bigStraight);
        } else {
            System.out.println("big straight in already done");
        }
    }

    public void setYacht(int yacht) {
        if (this.yacht == 0) {
            this.yacht = yacht;
            addToTotalScore(this.yacht);
        } else {
            System.out.println("yacht in already done");
        }
    }

    public int getOnes() {
        return ones;
    }

    public int getTwos() {
        return twos;
    }

    public int getThrees() {
        return threes;
    }

    public int getFours() {
        return fours;
    }

    public int getFives() {
        return fives;
    }

    public int getSixes() {
        return sixes;
    }

    public int getChoice() {
        return choice;
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public int getLittleStraight() {
        return littleStraight;
    }

    public int getBigStraight() {
        return bigStraight;
    }

    public int getYacht() {
        return yacht;
    }

    public int getTotalScore() {
        return totalScore;
    }

    private void rollDices() {
        for (int i = 0; i < dicesArray.length; i++) {
            double randomValue = Math.random();
            int intValue = (int) (randomValue * 6) + 1;
            dicesArray[i] = intValue;
        }
    }

    private void showRolledDicesArray() {
        int temp = 1;
        for (int i = 0; i < dicesArray.length; i++) {
            if (i != dicesArray.length-1) {
                System.out.print("Dice" + (i + temp) + ": " + dicesArray[i] + " | ");
            } else {
                System.out.println("Dice" + (i + temp) + ": " + dicesArray[i] + " |");
            }
        }
    }

    private void chooseDices() {
        System.out.println("===== Please insert dice numbers of to save without space =====");
        Scanner sc = new Scanner(System.in);
        System.out.print("Dice number: ");
        this.diceNumberToSave = sc.nextLine();
    }

    private void showSavedDicesArray() {
        int temp = 1;
        for(int i = 0; i < this.savedDicesArray.length; i++) {
            if (i != dicesArray.length-1) {
                System.out.print("Dice" + (i + temp) + ": " + dicesArray[i] + " | ");
            } else {
                System.out.println("Dice" + (i + temp) + ": " + dicesArray[i] + " |");
            }
        }
    }

}
