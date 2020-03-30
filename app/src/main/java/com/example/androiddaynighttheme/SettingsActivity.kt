package com.example.androiddaynighttheme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        rgTheme.check(
            rgTheme.getChildAt(
                SharedPrefsUtils.getIntegerPreference(
                    this,
                    "THEME", 0
                )
            ).id
        )
        setupThemeSelection()
    }

    private fun setupThemeSelection() {
        rgTheme.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbThemeLight -> {
                    AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO
                    )//enabling day mode/default app theme
                    refreshScreen(0)
                }
                R.id.rbThemeDark -> {
                    AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES
                    )//enabling night mode
                    refreshScreen(1)
                }
                R.id.rbThemeDefault -> {
                    AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    )// set app theme based on device theme
                    refreshScreen(2)
                }
            }
        }
    }

    private fun refreshScreen(int: Int) {
        SharedPrefsUtils.setIntegerPreference(
            this,
            "THEME", int
        )
        val intent =
            Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        finish()
    }
}