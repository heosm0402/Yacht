package com.smheo.Player;

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
}
