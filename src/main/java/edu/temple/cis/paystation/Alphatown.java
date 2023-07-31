package edu.temple.cis.paystation;

/**
 * The Alphatown class implements the TownRateStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Calculate the parking time based on the coin value inserted.
 * 2) The parking time is calculated by the formula: time = (amount * 2) / 5
 */
public class Alphatown implements TownRateStrategy {
    /**
     * Alphatown (Linear1 Rate Strategy)
     *
     * time = (amount * 2) / 5;
     * */
    @Override
    public int calculateTime(int coinValue) {
        int time = 0;
        time = (coinValue * 2) / 5;
        return time;
    }
}
