package br.ufpe.cin.if1001.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.if1001.util.activities.NameFor

import java.util.Random

import br.ufpe.cin.if1001.util.activities.sequence.string.generation.random.Generator
import br.ufpe.cin.if1001.util.activities.sequence.string.generation.random.commaJoin
import br.ufpe.cin.if1001.util.activities.sequence.string.generation.random.withLastAs

import br.ufpe.cin.if1001.util.activities.sequence.string.Possible

import br.ufpe.cin.if1001.util.activities.sequence.string.linking.startNextActivityInChain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        proceed()
    }

    private fun proceed() {
        startProperActivities(getActivitySequenceString())
    }

    private fun getActivitySequenceString(): String {
        return getPreferences(Context.MODE_PRIVATE)
                .getString(getString(R.string.activity_sequence_string), randomActivitySequenceString())!!
    }

    private fun randomActivitySequenceString(): String {
        return Generator(Possible.activityNames)
                .generateForAmount(Random().nextInt(4) + 1)
                .withLastAs(NameFor.finalActivity)
                .commaJoin()
    }

    private fun startProperActivities(activityNames: String) {
        startNextActivityInChain(getActivitySequenceString())
    }
}