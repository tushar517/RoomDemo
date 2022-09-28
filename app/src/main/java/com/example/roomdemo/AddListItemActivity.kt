package com.example.roomdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.Adapter.ListItemAdapter
import com.example.roomdemo.databinding.ActivityAddListItemBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.coroutineContext

class AddListItemActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityAddListItemBinding
    lateinit var itemListAdapter:ListItemAdapter
    var itemList=ArrayList<ProductItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MyTag","2nd activity")
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_list_item)
        itemListAdapter= ListItemAdapter(itemList)
        dataBinding.productlistRecyclerView.adapter = itemListAdapter
        val layoutManager = LinearLayoutManager(applicationContext)
        val dao = ItemDatabase.getInstance(applicationContext).productDao
        val repository = Repository(dao!!)
        dataBinding.productlistRecyclerView.layoutManager = layoutManager
        dataBinding.addToListBtn.setOnClickListener{
            if(dataBinding.txtProductName.text.isNullOrEmpty()){
                Toast.makeText(this,"Item name can't be empty",Toast.LENGTH_SHORT).show()
            }else{
                if (dataBinding.txtProductQty.text.isNullOrEmpty()){
                    Toast.makeText(this,"Item quantity can't be empty",Toast.LENGTH_SHORT).show()
                }else{
                    itemList.add(ProductItem(dataBinding.txtProductName.text.toString(),dataBinding.txtProductQty.text.toString()))
                    dataBinding.txtProductName.text=null
                    dataBinding.txtProductQty.text=null
                    itemListAdapter.notifyDataSetChanged()
                }
            }
        }

        dataBinding.SaveListBtn.setOnClickListener{
            if(itemList.isNullOrEmpty()){
                Toast.makeText(this,"Add atleast one item to the list",Toast.LENGTH_SHORT).show()
            }else {
                val title:String=intent.getStringExtra("title").toString()
                val product = Product(0, title, itemList.size, itemList, Date())
                lifecycleScope.launch {
                    repository.insert(product)
                }
                Toast.makeText(this, "list added successfully", Toast.LENGTH_LONG).show()
                itemList.removeAll(itemList)
                itemListAdapter.notifyDataSetChanged()
                onBackPressed()
            }
        }
    }

}