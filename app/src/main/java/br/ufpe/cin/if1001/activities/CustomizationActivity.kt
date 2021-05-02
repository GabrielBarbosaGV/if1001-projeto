package br.ufpe.cin.if1001.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.if1001.activities.adapters.CustomizationAdapter
import br.ufpe.cin.if1001.activities.databinding.ActivityCustomizationBinding
import br.ufpe.cin.if1001.util.activities.NameFor
import br.ufpe.cin.if1001.util.activities.sequence.string.Possible

class CustomizationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomizationBinding
    private lateinit var activityNameList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        proceed()
    }

    private fun proceed() {
        initializeAndDisplayActivityNameList()
        binding.setBindings()
    }

    private fun initializeAndDisplayActivityNameList() {
        activityNameList = activityNamesString().toActivityNameList()
        activityNameList.displayOnRecyclerView()
    }

    private fun ActivityCustomizationBinding.setBindings() {
        addItemButton.onClickAddActivityName()
    }

    private fun Button.onClickAddActivityName() = setOnClickListener {
        activityNameList.add(NameFor.clickButtonActivity)
        binding.activityNameList.adapter?.notifyItemChanged(activityNameList.size - 1)
    }

    private fun activityNamesString() = getPreferences(Context.MODE_PRIVATE)
                .getString(getString(R.string.activity_sequence_string), "")!!

    private fun MutableList<String>.displayOnRecyclerView() {
        binding.activityNameList.adapter = CustomizationAdapter(
                Possible.activityNames,
                this
        )
    }

    private fun String.toActivityNameList() = split(",").map{ trim() }.toMutableList()
}