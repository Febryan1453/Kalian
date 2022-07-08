package com.febryan.kalian.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.febryan.kalian.R
import com.febryan.kalian.activity.PerKategoriActivity
import com.febryan.kalian.model.DataKategori

class AdapterNamaKategori(var listNamaKategori: List<DataKategori?>?) : RecyclerView.Adapter<AdapterNamaKategori.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaKategori = itemView.findViewById<TextView>(R.id.tv_nama_kategori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_row_kategori, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNamaKategori.text = listNamaKategori?.get(position)?.namaKategori

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val i = Intent(context, PerKategoriActivity::class.java)
            i.putExtra("DTL", listNamaKategori?.get(position))
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return listNamaKategori!!.size
    }
}