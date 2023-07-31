package edu.temple.cis.paystation;

/**
 * The Deltatown class implements the TownRateStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Calculate the parking time based on the coin value inserted.
 * 2) The parking time is calculated by the formula: time = amount / 5
 */
public class Deltatown implements TownRateStrategy {
    /**
     * Deltatown (Linear2 Rate Strategy)
     *
     * time = amount / 5;
     * */
    @Override
    public int calculateTime(int coinValue) {
        int time = 0;
        time = coinValue / 5;
        return time;
    }
}
