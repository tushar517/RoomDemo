package com.example.roomdemo.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.ListDisplayActivity
import com.example.roomdemo.Product
import com.example.roomdemo.ProductItem
import com.example.roomdemo.R
import com.example.roomdemo.databinding.ProductListItemBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import java.io.Serializable
import java.lang.reflect.Type
import java.util.ArrayList

class ListAdapter(val context :Context,
    var productList:List<Product>
):RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ProductListItemBinding=
            DataBindingUtil.inflate(layoutInflater, R.layout.product_list_item,parent,false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.bind(productList[position],context)

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
class ListViewHolder(private val dataBinding:ProductListItemBinding):RecyclerView.ViewHolder(dataBinding.root){
    fun bind(item:Product,context: Context){
        dataBinding.productName.text = item.title
        dataBinding.productQty.text = item.listQty.toString()
        dataBinding.listCard.setOnClickListener {
            var intent = Intent(context , ListDisplayActivity::class.java)
            intent.putExtra("listItem",item.listItem as Serializable)
            context.startActivity(intent)
        }
    }
}