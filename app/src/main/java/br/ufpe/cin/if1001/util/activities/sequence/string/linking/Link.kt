package br.ufpe.cin.if1001.util.activities.sequence.string.linking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.if1001.util.activities.ActivityFor
import br.ufpe.cin.if1001.util.activities.sequence.string.modification.Modifier
import br.ufpe.cin.if1001.util.activities.NameFor

fun AppCompatActivity.startNextActivityInChain(nextActivitiesString: String?) {
    nextActivitiesString?.popHead()!!.apply {
        val activityToStartName = popped
        val nextActivityNames = rest

        val newIntent = Intent(this@startNextActivityInChain, ActivityFor.name(activityToStartName!!)).apply {
            putExtra(NameFor.nextActivities, nextActivityNames)
        }

        startActivity(newIntent)
    }
}

fun AppCompatActivity.startNextActivityInChain() {
    startNextActivityInChain(intent.getStringExtra(NameFor.nextActivities))
}

private fun String.popHead() = Modifier(this).popHead()