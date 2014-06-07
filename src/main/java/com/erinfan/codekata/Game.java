package com.erinfan.codekata;

import java.util.HashSet;

/**
 * Created by techops on 6/6/14.
 */
public class Game {

    private String randomDigit = "";
    private int inputTimes = 0;

    public void randomSet(int min, int max, int n, HashSet<Integer> set) {
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);
        }
    }

    public boolean createRandomDigit() {
        HashSet<Integer> set = new HashSet<>();
        randomSet(0, 9, 4, set);
        for (Integer integer : set) {
            randomDigit += integer;
        }
        if (!randomDigit.isEmpty()) {
            return true;
        }
        return false;
    }

    public void setRandomDigit(String randomDigit) {
        this.randomDigit = randomDigit;
    }

    public String startGuess(String userInput) {
        String ret = "";

        if (getInputTimes() == 6) {
            inputTimes = 0;
            return "Game Over";
        }

        inputTimes++;
        ret += getInputTimes();

        if (userInput.equals(randomDigit)) {
            inputTimes = 0;
            return "Congratulations!";
        }

        for (int i = 0; i < randomDigit.length(); i++) {
            if (userInput.charAt(i) == randomDigit.charAt(i)) {
                ret += "A";
            } else {
                ret += "B";
            }
        }
        return ret;
    }

    public String getRandomDigit() {
        return randomDigit;
    }

    public int getInputTimes() {
        return inputTimes;
    }
}
