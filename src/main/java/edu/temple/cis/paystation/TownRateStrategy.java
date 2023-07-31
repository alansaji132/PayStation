package edu.temple.cis.paystation;

public interface TownRateStrategy {
    /**
     * Calculate the parking time based on the coin value inserted.
     *
     * @param coinValue is an integer value representing the coin in cent. That
     * is, a quarter is coinValue=25, etc.
     * */
    public int calculateTime(int coinValue);
}
