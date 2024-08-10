package com.bugbd.themandroid

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bugbd.themandroid.databinding.StudentItemRowBinding

class StudentAdapter(
    private val list: List<Student>,
    private val context: Context
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    var selectPosition = -1
    var lastSelectPosition = -1

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
                Log.d("adapter","setOnClickListener - ${list[position]} and $position")
                selectPosition = position
                //un-selected
                notifyItemChanged(lastSelectPosition)
                lastSelectPosition = selectPosition
                //selected
                notifyItemChanged(selectPosition)
            }

            if (selectPosition == position){
                //when item select
                Log.d("adapter","if selected - $selectPosition and $position")
                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.select_item)
            }
            else{
                //first time else block call
                Log.d("adapter","else - $selectPosition and $position")
                holder.binding.main.background = ContextCompat.getDrawable(context, R.drawable.default_bg)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    class ViewHolder(val binding: StudentItemRowBinding) : RecyclerView.ViewHolder(binding.root)
}