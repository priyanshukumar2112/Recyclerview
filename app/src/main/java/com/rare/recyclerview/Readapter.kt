package com.rare.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Readapter (var detail : ArrayList<sdetail>) : RecyclerView.Adapter<Readapter.ViewHolder>(){

   class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var etName = view.findViewById<TextView>(R.id.etName)
        var etRollNo = view.findViewById<TextView>(R.id.etRollNo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.etName.setText(detail[position].name)
        holder.etRollNo.setText(detail[position].rollNo.toString())
    }

    override fun getItemCount(): Int {
        return  detail.size
    }
}