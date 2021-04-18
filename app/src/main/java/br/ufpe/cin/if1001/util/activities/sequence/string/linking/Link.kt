package br.ufpe.cin.if1001.util.activities.sequence.string.linking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.if1001.util.activities.ActivityFor
import br.ufpe.cin.if1001.util.activities.sequence.string.modification.Modifier

private val nextActivitiesString = "nextActivities"

fun AppCompatActivity.startNextActivityInChain() {
    intent.getStringExtra(nextActivitiesString)?.popHead()!!.apply {
        val activityToStartName = popped
        val nextActivityNames = rest

        val newIntent = Intent(this@startNextActivityInChain, ActivityFor.name(activityToStartName!!)).apply {
            putExtra(nextActivitiesString, nextActivityNames)
        }

        startActivity(newIntent)
    }
}

private fun String.popHead() = Modifier(this).popHead()