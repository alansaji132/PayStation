package edu.temple.cis.paystation;

/**
 * The Gammatown class implements the TownRateStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Calculate the parking time based on the coin value inserted.
 * 2) The parking time is calculated by the formula given in the calculateTime method.
 */
public class Gammatown implements TownRateStrategy {
    /**
     * Gammatown (Alternating1 Rate Strategy)
     *
     * On Weekdays Uses Progressive Rate
     * i.e. use Betatown
     *
     * On Weekends Uses Linear1 Rate Strategy
     * i.e. use Alphatown
     * */
    @Override
    public int calculateTime(int coinValue) {
        WeekendStrategy weekendStrategy = new WeekendStrategyImpl();
        if (weekendStrategy.isWeekend()) {
            Alphatown alphatown = new Alphatown();
            return alphatown.calculateTime(coinValue);
        } else {
            Betatown betatown = new Betatown();
            return betatown.calculateTime(coinValue);
        }
    }
}
