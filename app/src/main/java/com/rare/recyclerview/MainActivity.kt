package com.rare.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.rare.recyclerview.databinding.ActivityMainBinding
import com.rare.recyclerview.databinding.ItemListBinding

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
lateinit var binding: ActivityMainBinding
lateinit var adapter: Readapter
var detail = ArrayList<sdetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        layoutManager = LinearLayoutManager(this)
//        detail.add(sdetail("abc",1))
//        detail.add(sdetail("rbc",9))
//        detail.add(sdetail("ahc",4))
//        adapter = Readapter(detail)
//        binding.recylerView.layoutManager = layoutManager
//        binding.recylerView.adapter = adapter
        binding.btnFab.setOnClickListener {
            var dbinding = ItemListBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dbinding.root)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            

            dialog.show()
        }
    }
}