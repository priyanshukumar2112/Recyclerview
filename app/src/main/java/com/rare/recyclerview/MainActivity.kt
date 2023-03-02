package com.rare.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.rare.recyclerview.databinding.ActivityMainBinding
import com.rare.recyclerview.databinding.ItemListBinding

class MainActivity : AppCompatActivity(), RecyclerInterface {
 lateinit var layoutManager:LinearLayoutManager
lateinit var binding: ActivityMainBinding
lateinit var adapter: Readapter
var detail = ArrayList<sdetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
//        detail.add(sdetail("abc",1))
//        detail.add(sdetail("rbc",9))
//        detail.add(sdetail("ahc",4))
        adapter = Readapter(detail,this)
        binding.recylerView.layoutManager = layoutManager
        binding.recylerView.adapter = adapter
        binding.btnFab.setOnClickListener {
            var dbinding = ItemListBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dbinding.root)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
<<<<<<< Updated upstream
            dbinding.btnDelete.visibility = View.INVISIBLE
            dbinding.btnUpdate.visibility = View.INVISIBLE
            dbinding.btnSave.setOnClickListener{

                if(dbinding.etName.text.isEmpty()){
                    dbinding.etName.error = "Enter Name"
                }
                else if(dbinding.etRollNo.text.isEmpty()){
                    dbinding.etRollNo.error = "Enter Roll no"
                }
                else {
                    var name = dbinding.etName.text.toString()
                    var roll = dbinding.etRollNo.text.toString().toInt()
                    detail.add(sdetail(name,roll))
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
=======

>>>>>>> Stashed changes

            dialog.show()
        }
    }

    override fun edit(detail: sdetail) {

        
    }

    override fun delete(detail: sdetail) {
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("Delete Alert!!")
        dialog.setMessage("Are you sure ")
        dialog.setPositiveButton("yes"){_,_ ->

            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()

        }

        dialog.setNegativeButton("no"){ _,_ ->
            Toast.makeText(this, "operation cancel", Toast.LENGTH_SHORT).show()

        }
        dialog.show()

        System.out.println("click")


        }
    }
