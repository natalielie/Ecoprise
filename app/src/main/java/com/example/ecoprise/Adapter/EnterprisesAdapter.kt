package com.example.ecoprise.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ecoprise.Model.Enterprise
import com.example.ecoprise.Model.Movie
import com.example.ecoprise.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class EnterprisesAdapter(private val context: Context,
                         private val enterpriseList: MutableList<Enterprise>)
    :RecyclerView.Adapter<EnterprisesAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txt_name: TextView = itemView.txt_name
        val txt_kind: TextView = itemView.txt_kind
        val txt_client_id: TextView = itemView.txt_client_id

        fun bind(listItem: Enterprise) {

            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = enterpriseList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = enterpriseList[position]
        holder.bind(listItem)

        holder.txt_name.text = enterpriseList[position].name
        holder.txt_kind.text = enterpriseList[position].kind.toString()
        holder.txt_client_id.text = enterpriseList[position].client_id.toString()
    }

}