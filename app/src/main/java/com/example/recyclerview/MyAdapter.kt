package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var newsArrayList: ArrayList<News> , var context : Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row_layout_recycler_view , parent , false)
        return MyViewHolder(itemView)
    }

    // populate item with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hImage.setImageResource(currentItem.newImage)
        holder.hTitle.text = currentItem.newsHeading
    }

    // how many item present in yout arraylist
    override fun getItemCount(): Int {
        return newsArrayList.size
    }


    //it holds view so view can be created everytime , so memory can be saved
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.headingtext)
        val hImage = itemView.findViewById<ImageView>(R.id.headingImage)
    }


}