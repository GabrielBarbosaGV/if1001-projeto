package br.ufpe.cin.if1001.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        proceed()
    }

    private fun proceed() {
        startProperActivities(getActivitySequenceString())
    }

    private fun getActivitySequenceString(): String? {
        return getPreferences(Context.MODE_PRIVATE)
                .getString(getString(R.string.activity_sequence_string), randomActivitySequenceString())
    }

    private fun randomActivitySequenceString() {

    }
}