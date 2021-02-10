package app.tercer.juegofinal;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenciaNvl {

    private static String PREFS_KEY = "mypreferences";

    public static void setLevel(Context context, int level) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putInt("nivel", level);
        editor.commit();
    }
    public static int getLevel(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, context.MODE_PRIVATE);
        return  preferences.getInt("nivel", 0);
    }


    public static void lvlCompleto(Context context, int boolea) {
        SharedPreferences settings = context.getSharedPreferences("mypreferencess", context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putInt("nivel",boolea);
        editor.apply();
    }
    public static int getlvlCompleto(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("mypreferencess", context.MODE_PRIVATE);
        return  preferences.getInt("nivel", 0);
    }
}
