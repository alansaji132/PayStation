package edu.temple.cis.paystation;

/**
 * The Omegatown class implements the TownRateStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Calculate the parking time based on the coin value inserted.
 * 2) The parking time is calculated by the formula given in the calculateTime method.
 */
public class Omegatown implements TownRateStrategy {
    /**
     * Omegatown (Alternating2 Rate Strategy)
     *
     * On Weekdays Uses Linear1 Rate
     * i.e. use Alphatown
     *
     * On Weekends Free
     * i.e. return 0
     * */
    @Override
    public int calculateTime(int coinValue) {
        WeekendStrategy weekendStrategy = new WeekendStrategyImpl();
        if (weekendStrategy.isWeekend()) {
            return 0;
        } else {
            Alphatown alphatown = new Alphatown();
            return alphatown.calculateTime(coinValue);
        }
    }
}
