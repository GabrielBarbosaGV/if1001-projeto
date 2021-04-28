package br.ufpe.cin.if1001.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.webkit.WebView
import android.widget.Button
import br.ufpe.cin.if1001.activities.databinding.ActivityDisplayBinding
import br.ufpe.cin.if1001.util.activities.Default
import br.ufpe.cin.if1001.util.activities.NameFor

class DisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        proceed()
    }

    private fun proceed() {
        binding.apply {
            webView.loadUrl(preferencesUrlOrDefault())
            button.manipulateOpacity()
        }
    }

    private fun preferencesUrlOrDefault() = getPreferences(Context.MODE_PRIVATE)
        .getString(NameFor.urlOfContentToDisplay, Default.urlOfContentToDisplay)!!

    private fun Button.manipulateOpacity() = startAnimation(alphaAnimation())

    private fun alphaAnimation() = AlphaAnimation(0f, 1f).apply {
        duration = Default.opacityAnimationDurationForDisplayActivity
        startOffset = Default.opacityAnimationOffsetForDisplayActivity
        fillAfter = true
    }
}