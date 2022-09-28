package com.example.roomdemo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.ProductItem
import com.example.roomdemo.R
import com.example.roomdemo.databinding.ProductListItemBinding

class ListItemAdapter(val list:List<ProductItem>):RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding :ProductListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_list_item,parent,false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class ListItemViewHolder(private val dataListItemBinding: ProductListItemBinding):RecyclerView.ViewHolder(dataListItemBinding.root){
    fun bind(item: ProductItem){
        dataListItemBinding.productName.text = item.ItemName
        dataListItemBinding.productQty.text = item.ItemQty
    }
}