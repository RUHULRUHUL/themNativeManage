package com.bugbd.themandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bugbd.themandroid.databinding.StudentItemRowBinding

class MultipleSelectionAdapter(
    private val list: List<Student>,
    private val context: Context
) : RecyclerView.Adapter<MultipleSelectionAdapter.ViewHolder>() {
    var selectPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            StudentItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            holder.binding.idTxt.text = list[position].id.toString()
            holder.binding.nameTxt.text = list[position].name
            holder.binding.main.setOnClickListener {
                if (list[position].isSelected){
                    list[position].isSelected = false
                    notifyItemChanged(position)
                }else{
                    list[position].isSelected = true
                    notifyItemChanged(position)
                }

//                selectPosition = position
//                notifyItemChanged(selectPosition)
            }
            if (list[position].isSelected){
                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.select_item)

            }else{
                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.default_bg)

            }
//            if (selectPosition == position){
//                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.select_item)
//            }else{
//                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.default_bg)
//            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    class ViewHolder(val binding: StudentItemRowBinding) : RecyclerView.ViewHolder(binding.root)
}