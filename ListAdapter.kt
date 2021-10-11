package com.example.prelim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prelim.data.Inquiry
import kotlinx.android.synthetic.main.sample_inquiry.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){
    private var inquryList = emptyList<Inquiry>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sample_inquiry, parent, false))
    }

    override fun getItemCount(): Int {
        return inquryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = inquryList[position]
        holder.itemView.name_txt.text = currentItem.name
        holder.itemView.inquiry_text.text = currentItem.inquiry
    }

    fun setData(inquiries: List<Inquiry>){
        this.inquryList = inquiries
        notifyDataSetChanged()
    }
}