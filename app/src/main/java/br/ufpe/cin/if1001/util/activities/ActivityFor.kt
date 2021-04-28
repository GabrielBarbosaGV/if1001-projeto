package br.ufpe.cin.if1001.util.activities

import android.app.Activity
import br.ufpe.cin.if1001.activities.ClickButtonActivity

class ActivityFor {
    companion object {
        fun name(name: String): Class<out Activity> {
            return when (name) {
                NameFor.clickButtonActivity -> ClickButtonActivity::class.java
                else -> TODO("Add default activity")
            }
        }
    }
}