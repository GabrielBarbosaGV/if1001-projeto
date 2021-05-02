package br.ufpe.cin.if1001.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.if1001.activities.databinding.CustomizationChoiceBinding

class CustomizationAdapter(val possibleActivityNames: List<String>, val selectedActivityNameSequence: MutableList<String>): RecyclerView.Adapter<CustomizationAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: CustomizationChoiceBinding): RecyclerView.ViewHolder(binding.root) {
        val spinner: Spinner = binding.spinner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomizationAdapter.ViewHolder {
        return ViewHolder(
                CustomizationChoiceBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.spinner.apply {
            adapter = holder.arrayAdapter()
            setSelection(possibleActivityNames.selectionIndex(position))
            onChangeAlterActivityNameSequence(position)
        }
    }

    private fun Spinner.onChangeAlterActivityNameSequence(activityNameSequencePosition: Int) {
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedActivityNameSequence[activityNameSequencePosition] =
                        possibleActivityNames[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun ViewHolder.arrayAdapter() = ArrayAdapter(
            binding.root.context,
            android.R.layout.simple_spinner_item,
            possibleActivityNames
    )

    private fun List<String>.selectionIndex(position: Int) =
            indexOf(selectedActivityNameSequence[position])

    override fun getItemCount() = possibleActivityNames.size
}