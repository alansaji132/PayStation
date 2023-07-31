package edu.temple.cis.paystation;

import java.util.Calendar;
import java.util.Date;

/**
 * The WeekendStrategyImpl class implements the WeekendStrategy interface.
 *
 * Responsibilities:
 *
 * 1) Determine if the current day is a weekend day.
 */
public class WeekendStrategyImpl implements WeekendStrategy {
    @Override
    public boolean isWeekend() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }
}
