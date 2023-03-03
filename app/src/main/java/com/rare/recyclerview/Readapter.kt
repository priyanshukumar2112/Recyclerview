package com.rare.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Readapter (var detail : ArrayList<sdetail>, var recyclerInterface :RecyclerInterface) : RecyclerView.Adapter<Readapter.ViewHolder>(){

   class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var etName = view.findViewById<TextView>(R.id.tvName)
        var etphone = view.findViewById<TextView>(R.id.tvPhone)
       var etAddress = view.findViewById<TextView>(R.id.tvAddress)
       var btnedit = view.findViewById<ImageButton>(R.id.btnUpdate)
       var btnDelete = view.findViewById<ImageButton>(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_show, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.etName.setText(detail[position].name)
        holder.etAddress.setText(detail[position].address)
        holder.etphone.setText(detail[position].phone.toString())

        holder.btnDelete.setOnClickListener{
            recyclerInterface.delete(position)
        }
        holder.btnedit.setOnClickListener {
            recyclerInterface.edit(position)
        }
    }

    override fun getItemCount(): Int {
        return  detail.size
    }
}