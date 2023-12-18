package com.example.projectnew21.dataClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectnew21.R
import com.example.projectnew21.databinding.ActivityMain2Binding
import com.example.projectnew21.databinding.LayoutItemBinding

class RecyclerViewAdapter(private val context: Context, private val itemList: List<ApiCard>) :

    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private lateinit var binding: LayoutItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view2 = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        val view = LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textViewTitle.text = item.code
        // Configure outros elementos conforme necessário
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: LayoutItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val textViewTitle: TextView = itemView.txtCard
        // Adicione outros elementos conforme necessário
    }
}