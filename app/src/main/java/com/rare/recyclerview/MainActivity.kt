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
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
            dbinding.btnDelete.visibility = View.INVISIBLE
            dbinding.btnUpdate.visibility = View.INVISIBLE
            dbinding.btnSave.setOnClickListener{

                if(dbinding.etName.text.isEmpty()){
                    dbinding.etName.error = "Enter Name"
                }
                else if(dbinding.etPhno.text.isEmpty()){
                    dbinding.etPhno.error = "Enter Roll no"
                }
                else if(dbinding.etAddress.text.isEmpty()){
                    dbinding.etAddress.error = "Enter Roll no"
                }
                else {
                    var name = dbinding.etName.text.toString()
                    var address = dbinding.etAddress.text.toString()
                    var phone = dbinding.etPhno.text.toString().toInt()
                    detail.add(sdetail(name,address,phone))
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }

    override fun edit(position:Int) {

        var dbinding = ItemListBinding.inflate(layoutInflater)
        var dialog = Dialog(this)
        dialog.setContentView(dbinding.root)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        dbinding.btnDelete.visibility = View.INVISIBLE
        dbinding.btnUpdate.visibility = View.INVISIBLE

        dbinding.etName.setText(detail[position].name.toString())
        dbinding.etAddress.setText(detail[position].address.toString())
        dbinding.etPhno.setText(detail[position].phone.toString())
        dbinding.btnSave.setOnClickListener{

            if(dbinding.etName.text.isEmpty()){
                dbinding.etName.error = "Enter Name"
            }
            else if(dbinding.etPhno.text.isEmpty()){
                dbinding.etPhno.error = "Enter phone number"
            }
            else {
                var name = dbinding.etName.text.toString()
                var address = dbinding.etAddress.text.toString()
                var phone = dbinding.etPhno.text.toString().toInt()
                detail.set(position,sdetail(name, address,phone ))
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    override fun delete(position:Int) {
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("Delete Alert!!")
        dialog.setMessage("Are you sure ")
        dialog.setPositiveButton("yes"){_,_ ->
            detail.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()

        }

        dialog.setNegativeButton("no"){ _,_ ->
            Toast.makeText(this, "operation cancel", Toast.LENGTH_SHORT).show()

        }
        dialog.show()

        System.out.println("click")


        }
    }
