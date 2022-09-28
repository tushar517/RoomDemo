package com.example.roomdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.Adapter.ListAdapter
import com.example.roomdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityMainBinding
    lateinit var repository: Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        dataBinding.AddItemBtn.setOnClickListener{
            if(dataBinding.listTitle.text.isNullOrEmpty()){
                Toast.makeText(this,"Please Add List Title",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,AddListItemActivity::class.java)
                intent.putExtra("title",dataBinding.listTitle.text.toString())
                dataBinding.listTitle.text = null
                startActivity(intent)
            }
        }
        val dao = ItemDatabase.getInstance(applicationContext).productDao
        repository = Repository(dao!!)
        val layoutManager = LinearLayoutManager(applicationContext)
        dataBinding.listRecyclerView.layoutManager = layoutManager
//        displayItemList()
    }

    override fun onResume() {
        displayItemList()
        super.onResume()
    }

    override fun onStop() {
        Log.i("MyTag","first activity stopped")
        super.onStop()
    }

//    override fun onRestart() {
//        displayItemList()
//        super.onRestart()
//    }

    private fun displayItemList(){
        repository.getAllItem().observe(this, Observer {
            val  adapter = ListAdapter(this , it)
            dataBinding.listRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }
}