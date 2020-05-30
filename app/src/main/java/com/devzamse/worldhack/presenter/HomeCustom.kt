package com.devzamse.worldhack.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devzamse.worldhack.R
import com.devzamse.worldhack.`interface`.RecyclerInterface

class HomeCustom(items: ArrayList<Homes>, var listener: RecyclerInterface): RecyclerView.Adapter<HomeCustom.ViewHolder>() {

    var items: ArrayList<Homes>? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.recycler_card, parent, false)
        val viewHolder = ViewHolder(vista, listener)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.imagen?.setImageResource(item?.imagen!!)
        holder.sub?.text = item?.sub
        holder.title?.text = item?.title
    }

    class ViewHolder(vista: View, listener: RecyclerInterface): RecyclerView.ViewHolder(vista), View.OnClickListener{
        var vista = vista
        var imagen: ImageView? = null
        var sub: TextView? = null
        var title: TextView? = null
        var listener: RecyclerInterface? = null

        init {
            imagen = vista.findViewById(R.id.imagen)
            sub = vista.findViewById(R.id.sub)
            title = vista.findViewById(R.id.title)
            this.listener = listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

    }
}