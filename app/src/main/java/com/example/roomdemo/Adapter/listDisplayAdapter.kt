package com.example.roomdemo.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.ProductItem
import com.example.roomdemo.R
import com.example.roomdemo.databinding.ProductListItemBinding

class listDisplayAdapter(
    val ItemList:List<ProductItem>
):RecyclerView.Adapter<ListDisplayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDisplayViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ProductListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.product_list_item,parent,false)
        return ListDisplayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListDisplayViewHolder, position: Int) {
        holder.bind(ItemList[position])
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}

class ListDisplayViewHolder(private val dataListItemBinding: ProductListItemBinding):RecyclerView.ViewHolder(dataListItemBinding.root){
    fun bind(Item:ProductItem){
        dataListItemBinding.productName.text = Item.ItemName
        dataListItemBinding.productQty.text = Item.ItemQty

    }
}