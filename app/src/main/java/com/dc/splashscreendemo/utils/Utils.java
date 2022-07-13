package com.dc.splashscreendemo.utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * this class is used to reuse the code
 */
public class Utils {
    /**
     * @param inputAge takes String age
     * @return age if valid else -1 if age is not between 1-100
     */
    public static int validateAge(String inputAge) {
        int age = Integer.parseInt(inputAge);
        if (age > 0 && age < 101)
            return age;
        else
            return -1;
    }

    /**
     * @return random day with 06-2022 date format
     */
    public static String getRandomDate() {
        return getNumberBetween1to31() + "-06-2022";
    }

    /**
     * @return float value between 1 to 10.5
     */
    public static float getRandomNumber() {
        return Float.valueOf(new DecimalFormat("00.0").format(1.0f + new Random().nextFloat() * (11f - 0.5f)));
    }

    /**
     * Generates the random number from 1 to 31
     *
     * @return number
     */
    private static int getNumberBetween1to31() {
        Random r = new Random();
        int low = 1;
        int high = 32;
        return r.nextInt(high - low) + low;
    }

    /**
     * @param index
     * @return
     */
    public static String getBrandName(int index) {
        switch (index) {
            case 1:
                return "Bisleri";
            case 2:
                return "Aquafina";
            case 3:
            default:
                return "Bailley";
        }
    }
}
