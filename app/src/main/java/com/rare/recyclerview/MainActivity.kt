package com.rare.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.rare.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
lateinit var binding: ActivityMainBinding
lateinit var adapter: Readapter
var detail = ArrayList<sdetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        detail.add(sdetail("abc",1))
        detail.add(sdetail("rbc",9))
        detail.add(sdetail("ahc",4))
        adapter = Readapter(detail)
        binding.recylerView.layoutManager = layoutManager
        binding.recylerView.adapter = adapter
    }
}