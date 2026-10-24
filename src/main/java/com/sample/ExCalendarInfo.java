package com.sample;

import java.util.Calendar;
import java.util.TimeZone;

public class ExCalendarInfo {

  public static void main(String[] args) {

    // create Calendar instance
    Calendar now = Calendar.getInstance();

    // get current TimeZone using getTimeZone method of Calendar class
    TimeZone timeZone = now.getTimeZone();
    // display current TimeZone using getDisplayName() method of TimeZone class
    System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
    System.out.println("Current milliseconds since Jan 1, 1970 are :" + now.getTimeInMillis());

    // get current date, year and month
    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
    // month start from 0 to 11
    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
    System.out.println("Current Date is : " + now.get(Calendar.DATE));

    // get current time information
    System.out.println("Current Hour in 12 hour format is : " + now.get(Calendar.HOUR));
    System.out.println("Current Hour in 24 hour format is : " + now.get(Calendar.HOUR_OF_DAY));
    System.out.println("Current Minute is : " + now.get(Calendar.MINUTE));
    System.out.println("Current Second is : " + now.get(Calendar.SECOND));
    System.out.println("Current Millisecond is : " + now.get(Calendar.MILLISECOND));

    // display full date time
    System.out.println(
        "Current full date time is : "
            + (now.get(Calendar.MONTH) + 1)
            + "-"
            + now.get(Calendar.DATE)
            + "-"
            + now.get(Calendar.YEAR)
            + " "
            + now.get(Calendar.HOUR_OF_DAY)
            + ":"
            + now.get(Calendar.MINUTE)
            + ":"
            + now.get(Calendar.SECOND)
            + "."
            + now.get(Calendar.MILLISECOND));
    System.out.println(
        "Current date : "
            + now.get(Calendar.YEAR)
            + "-"
            + (now.get(Calendar.MONTH) + 1)
            + "-"
            + now.get(Calendar.DATE)
            + "\n Current time : "
            + now.get(Calendar.HOUR_OF_DAY)
            + ":"
            + now.get(Calendar.MINUTE)
            + ":"
            + now.get(Calendar.SECOND));
    // create an array of days
    String[] strDays =
        new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday"};
    // Day_OF_WEEK starts from 1 while array index starts from 0
    System.out.println("Current day is : " + strDays[now.get(Calendar.DAY_OF_WEEK) - 1]);

    // create an array of months
    String[] strMonths =
        new String[] {
          "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
    System.out.println("Current month is : " + strMonths[now.get(Calendar.MONTH)]);

    System.out.println("Current week of month is : " + now.get(Calendar.WEEK_OF_MONTH));
    System.out.println("Current week of year is : " + now.get(Calendar.WEEK_OF_YEAR));

    // use getTime() method of Calendar class to get date and time
    System.out.println("Today is : " + now.getTime());

    // add months to current date using Calendar.add method
    now.add(Calendar.MONTH, 10);
    now.add(Calendar.WEEK_OF_YEAR, 10);

    System.out.println(
        "date after 10 months + 10 week: "
            + (now.get(Calendar.MONTH) + 1)
            + "-"
            + now.get(Calendar.DATE)
            + "-"
            + now.get(Calendar.YEAR));

    // substract months from current date using Calendar.add method
    Calendar futureCal = Calendar.getInstance();
    futureCal.add(Calendar.MONTH, -5);
    futureCal.set(Calendar.YEAR, 1990);
    System.out.println(
        "date before 5 months : "
            + (futureCal.get(Calendar.MONTH) + 1)
            + "-"
            + futureCal.get(Calendar.DATE)
            + "-"
            + futureCal.get(Calendar.YEAR));
    System.out.println("Is futureCal after now ? : " + futureCal.after(now));
    System.out.println("Is old before now ? : " + futureCal.before(now));
  } // main end
}

/*
Typical output would be
Current date : 12-25-2007
date after 10 months : 10-25-2008
date before 5 months : 7-25-2007
*/
