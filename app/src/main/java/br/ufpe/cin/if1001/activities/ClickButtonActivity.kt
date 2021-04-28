package br.ufpe.cin.if1001.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import br.ufpe.cin.if1001.activities.databinding.ActivityClickButtonBinding
import br.ufpe.cin.if1001.util.activities.NameFor

import br.ufpe.cin.if1001.util.activities.sequence.string.linking.startNextActivityInChain

class ClickButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClickButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBindings()
    }

    private fun setBindings() {
        binding.button.setOnClickListener {
            startNextActivityInChain()
        }
    }
}