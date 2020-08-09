package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();
    private final static String YEAR = "Year";
    private final static String MONTH = "Month";
    private final static String DATE = "Date";
    private final static String HOUR = "Hour";
    private final static String MINUTE = "Minute";


    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        year = tryParse(0, 4, YEAR, 2000, 2012);
        month = tryParse(5, 7, MONTH, 1, 12);
        date = tryParse(8, 10, DATE, 1, 31);

        if (dateAndTimeString.substring(11, 12).equals("Z")) {
            hour = 0;
            minute = 0;
        } else {
            hour = tryParse(11, 13, HOUR, 0, 23);
            minute = tryParse(14, 16, MINUTE, 0, 59);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public int tryParse(int start, int end, String typeName,  int min, int max) {
        int type;
        try {
            String typeString = dateAndTimeString.substring(start, end);
            type = Integer.parseInt(typeString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(typeName + " string is less than " + (end - start) +" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(typeName + " is not an integer");
        }
        if (type < min || type > max) {
            throw new IllegalArgumentException(typeName + " cannot be less than " + min +" or more than " + max);
        }
        return type;
    }
}
