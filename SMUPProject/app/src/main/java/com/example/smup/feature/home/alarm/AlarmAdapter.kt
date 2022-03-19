package com.example.smup.feature.home.alarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smup.R
import java.util.*
import kotlin.collections.ArrayList

class AlarmAdapter(private val alarmList : ArrayList<AlarmData>):RecyclerView.Adapter<AlarmAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val list = alarmList[position]
        holder.apply {
            bind(list)
        }
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    class CustomViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val view : View = itemView
        val itemText : TextView = view.findViewById(R.id.item_text)

        fun bind(list: AlarmData){
            itemText.text = list.itemText
        }
    }

    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(alarmList, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }

    fun removeData(position: Int) {
        alarmList.removeAt(position)
        notifyItemRemoved(position)
    }
}