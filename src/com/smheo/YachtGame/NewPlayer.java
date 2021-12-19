package com.smheo.YachtGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class NewPlayer {
    private int playerNumber = 0;
    private int[] dicesArray = {0, 0, 0, 0, 0};
    private int rollDiceCount = 0;
    private String diceNumberToSave;
    private String rank;
    private Map<String, Integer> scoreTable = new HashMap<>();

    public Map<String, Integer> getScoreTable() {
        return scoreTable;
    }

    public void setScoreTable(Map<String, Integer> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public int[] getDicesArray() {
        return dicesArray;
    }

    public void setDicesArray(int[] dicesArray) {
        this.dicesArray = dicesArray;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDiceNumberToSave() {
        return diceNumberToSave;
    }

    public void setDiceNumberToSave(String diceNumberToSave) {
        this.diceNumberToSave = diceNumberToSave;
    }

    public int getRollDiceCount() {
        return rollDiceCount;
    }

    public void setRollDiceCount(int rollDiceCount) {
        this.rollDiceCount = rollDiceCount;
    }

    private void addRollDiceCount() {
        this.rollDiceCount++;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void turn() {
        setDicesArray(new int[] {0, 0, 0, 0, 0});
        while (getRollDiceCount() < 3){
            System.out.println("[GAME INFO] PLAYER" + getPlayerNumber() + " TURN ROUND" + (getPlayerNumber()+1));
            rollDice();
            if (getRollDiceCount() <= 2) {
                showDicesArray();
                if (chooseGoOrStop() == 2) {
                    selectRank();
                    setRollDiceCount(0);
                    return;
                }
                chooseDiceNumberToSave();
            }
        }
        showDicesArray();
        selectRank();
        setRollDiceCount(0);
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

    private int chooseGoOrStop() {
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("[SELECT] Go(1) or Stop(2): ");
            choice = sc.nextInt();
        } while (!(choice == 1 || choice == 2));
        return choice;
    }

    private void selectRank() {
        String chosenRank;
        String[] toCheckValidRank = {"1", "2", "3", "4", "5", "6", "C", "FK", "FH", "SS", "BS", "Y"};
        boolean isDuplicatedRank;
        boolean isValidRank;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("[GAME INFO] Rank list");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("| ONES(1) | TWOS(2) | THREES(3) | FOURS(4) | FIVES(5) | SIXES(6) | CHOICE(C)    |");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("| 4ofAKind(FK) | FullHOUSE(FH) | SmallStraight(SS) | BigStraight(BS) | Yacht(Y) |");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.print("[SELECT] Rank: ");
            chosenRank = sc.nextLine();

            isDuplicatedRank = scoreTable.containsKey(chosenRank);
            if (isDuplicatedRank) {
                System.out.println("[GAME INFO] Already chosen rank: " + chosenRank);
            }
            isValidRank = Arrays.asList(toCheckValidRank).contains(chosenRank);
            if (!isValidRank) {
                System.out.println("[GAME INFO] Invalid rank: " + chosenRank);
            }
        } while (isDuplicatedRank || (!isValidRank));

        setRank(chosenRank);
    }

    private void showDicesArray() {
        System.out.println("Dice Array: " + Arrays.toString(dicesArray));
    }

    private void chooseDiceNumberToSave() {
        Scanner sc = new Scanner(System.in);
        String[] toCheckValidation = {"1", "2", "3", "4", "5"};
        boolean isNotValidDiceNumber = false;
        String[] diceNumberArray;

        do {
            System.out.print("[SELECT] DICE INDEX TO SAVE (1~5, with space): ");
            setDiceNumberToSave(sc.nextLine());
            diceNumberArray = getDiceNumberToSave().split(" ");

            for (String diceNumber : diceNumberArray) {
                if (!Arrays.asList(toCheckValidation).contains(diceNumber)){
                    isNotValidDiceNumber = true;
                    System.out.println("[GAME INFO] WRONG DICE NUMBER");
                } else {
                    isNotValidDiceNumber = false;
                }
            }
        } while (isNotValidDiceNumber);

        for (int i = 0; i < this.dicesArray.length; i++) {
            if (Arrays.asList(diceNumberArray).contains(Integer.toString(i + 1))) {
                continue;
            } else {
                this.dicesArray[i] = 0;
            }
        }
    }

    public Map<String, Integer> roundSummary() {
        LinkedHashMap<String, Integer> roundScoreSummaryMap = new LinkedHashMap<>();
        String[] rankType = {"1", "2", "3", "4", "5", "6", "C", "FK", "FH", "SS", "BS", "Y"};
        for (String rank : rankType) {
            roundScoreSummaryMap.put(rank, scoreTable.getOrDefault(rank, 0));
        }
        return roundScoreSummaryMap;
    }
}
