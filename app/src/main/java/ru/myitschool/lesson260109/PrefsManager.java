package ru.myitschool.lesson260109;

import android.content.SharedPreferences;

public class PrefsManager {
    public final static String NAME = "MY GAME";
    private final static String KEY_SCORE = "KEY_SCORE";

    private final SharedPreferences sharedPreferences;

    public PrefsManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setScore(int score) {
        sharedPreferences.edit().putInt(KEY_SCORE, score).apply();
    }

    public int getScore() {
        return sharedPreferences.getInt(KEY_SCORE, 0);
    }
}
