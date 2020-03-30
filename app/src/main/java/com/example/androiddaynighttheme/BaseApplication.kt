package com.example.androiddaynighttheme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        when (SharedPrefsUtils.getIntegerPreference(
            this,
            "THEME", 0
        )) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )//enabling day mode/default app theme
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )//enabling night mode
            }
            2 -> {
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                )// set app theme based on device theme
            }
        }
    }
}