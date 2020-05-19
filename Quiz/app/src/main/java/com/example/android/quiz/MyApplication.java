package com.example.android.quiz;

import android.app.Application;

public class MyApplication extends Application {

    public static int score = 0;

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        MyApplication.score = score;
    }
}
