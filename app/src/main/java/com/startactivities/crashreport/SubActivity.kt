package com.startactivities.crashreport

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if (intent.getBooleanExtra(IS_DIRECT_LAUNCH, false)) {
            startActivities()
        }
    }

    private fun startActivities() {
        val mainActivityIntent = MainActivity.createIntent(this)
        val subActivityIntent = createIntent(this, false)
        startActivities(arrayOf(mainActivityIntent, subActivityIntent))
    }

    companion object {
        private const val IS_DIRECT_LAUNCH = "is_direct_launch"

        fun createIntent(context: Context, isDirectLaunch: Boolean): Intent {
            return Intent(context, SubActivity::class.java)
                .putExtra(IS_DIRECT_LAUNCH, isDirectLaunch)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
    }
}