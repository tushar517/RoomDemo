package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.Adapter.ListDisplayViewHolder
import com.example.roomdemo.Adapter.listDisplayAdapter
import com.example.roomdemo.databinding.ActivityListDisplayBinding

class ListDisplayActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityListDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_list_display)
        val list= intent.getSerializableExtra("listItem") as List<ProductItem>
        val adapter = listDisplayAdapter(list)
        val layoutManager = LinearLayoutManager(applicationContext)
        dataBinding.recyclerView.adapter=adapter
        dataBinding.recyclerView.layoutManager= layoutManager

    }
}