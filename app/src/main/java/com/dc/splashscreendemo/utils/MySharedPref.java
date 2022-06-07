package com.dc.splashscreendemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPref {

    private static MySharedPref myPreferences;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private MySharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static MySharedPref getPreferences(Context context) {
        if (myPreferences == null) myPreferences = new MySharedPref(context);
        return myPreferences;
    }

    public void storeLoginData(String name, int age) {
        editor.putString(Constants.KEY_NAME, name);
        editor.putInt(Constants.KEY_AGE, age);
        editor.apply();
    }

    public String getUserName() {
        //if no data is available for Constants.KEY_NAME then this getString() method returns
        //a default value that is mentioned in second parameter
        return sharedPreferences.getString(Constants.KEY_NAME, "NA");
    }

    public int getAge() {
        return sharedPreferences.getInt(Constants.KEY_AGE, -1); //if user's age not found then it'll return -1
    }

    public void clearSharedPref() {
        editor.clear();
        editor.commit();
    }
}
