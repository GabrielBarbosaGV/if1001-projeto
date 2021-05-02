package br.ufpe.cin.if1001.util.activities

import android.app.Activity
import br.ufpe.cin.if1001.activities.ClickButtonActivity
import br.ufpe.cin.if1001.activities.DisplayActivity

class ActivityFor {
    companion object {
        fun name(name: String) = when (name) {
            NameFor.clickButtonActivity -> ClickButtonActivity::class.java
            else -> DisplayActivity::class.java
        }
    }
}