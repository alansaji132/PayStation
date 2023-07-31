package edu.temple.cis.paystation;

/**
 * The Betatown class implements the TownRateStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Calculate the parking time based on the coin value inserted.
 * 2) The parking time is calculated by the formula given in the calculateTime method.
 */
public class Betatown implements TownRateStrategy {
    /**
     * Betatown (Progressive Rate Strategy)
     *
     * less than an hour (60 Min) so amount <150
     * time = (amount * 2) / 5;
     *
     * between 1st hour and 2nd hour so 350>amount >=150
     * time = (amount - 150) * (3 / 10) + 60;
     *
     * greater than 2 hours so amount >= 350
     * time = (amount - 350) / 5 + 120;
     * */
    @Override
    public int calculateTime(int coinValue) {
        int time = 0;
        if (coinValue < 150) {
            time = (coinValue * 2) / 5;
        } else if (coinValue >= 150 && coinValue < 350) {
            time = (coinValue - 150) * (3/10) + 60;
        } else if (coinValue >= 350) {
            time = (coinValue - 350) / 5 + 120;
        }
        return time;
    }
}
