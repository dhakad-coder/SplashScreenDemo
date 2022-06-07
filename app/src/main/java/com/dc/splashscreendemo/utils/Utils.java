package com.dc.splashscreendemo.utils;

import android.app.Activity;
import android.content.Context;

public class Utils {
    public static int validateAge(String inputAge) {
        int age = Integer.parseInt(inputAge);
        if (age > 0 && age < 110)
            return age;
        else
            return -1;
    }
}
