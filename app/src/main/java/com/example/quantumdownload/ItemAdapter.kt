package com.example.quantumdownload

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class ItemAdapter(val context: Context, val list: ArrayList<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = list[position]
        if (holder is MyViewHolder){
            holder.itemView.iv_of_itemview.setImageResource(image)
            holder.itemView.iv_of_itemview.setOnClickListener {
                //Toast.makeText(context, "${position+1}", Toast.LENGTH_SHORT).show()
                var bundle: Bundle = Bundle()
                val intent = Intent(context, SubjectActivity::class.java)
                intent.putExtra("sem",position+1)
                startActivity(context, intent, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
}