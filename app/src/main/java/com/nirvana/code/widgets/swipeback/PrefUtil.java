package com.nirvana.code.widgets.swipeback;

import android.content.Context;
import android.content.SharedPreferences;

import com.nirvana.code.Constant;
import com.nirvana.code.NivanaApplication;

/**
 * Created by laucherish on 16/3/30.
 */
public class PrefUtil {

    private static final String PRE_NAME = "io.github.laucherish.purezhihud_preferences";
    private static final String PRE_NIGHT = "night";

    private static SharedPreferences getSharedPreferences() {
        return NivanaApplication.mAPP
                .getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
    }

    public static void setNight(){
        getSharedPreferences().edit().putBoolean(PRE_NIGHT, true).commit();
    }

    public static void setDay(){
        getSharedPreferences().edit().putBoolean(PRE_NIGHT, false).commit();
    }

    public static void changeDayNight(){
        boolean change = !getSharedPreferences().getBoolean(PRE_NIGHT, false);
        getSharedPreferences().edit().putBoolean(PRE_NIGHT, change).commit();
    }

    public static boolean isNight(){
        return getSharedPreferences().getBoolean(PRE_NIGHT, false);
    }

    public static int getThemeRes(){
        if (!isNight()) {
            return Constant.RESOURCES_DAYTHEME;
        } else {
            return Constant.RESOURCES_NIGHTTHEME;
        }
    }
}
