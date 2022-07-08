package com.febryan.kalian.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.febryan.kalian.R
import com.febryan.kalian.activity.DetailWisataActivity
import com.febryan.kalian.model.DataItem
import com.febryan.kalian.model.DataKategori
import com.squareup.picasso.Picasso

class AdapterWisata(var listWisata: List<DataItem?>?) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgWisata = itemView.findViewById<ImageView>(R.id.img_wisata)
        val tvNamaWisata = itemView.findViewById<TextView>(R.id.tv_nama_wisata)
        val tvHargaWisata = itemView.findViewById<TextView>(R.id.tv_harga_wisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_row_wisata, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvNamaWisata.text = listWisata?.get(position)?.namaWisata
        holder.tvHargaWisata.text = listWisata?.get(position)?.harga.toString()
        Picasso.get()
            .load(listWisata?.get(position)?.image)
            .placeholder(R.drawable.carousel2)  //untuk sementara loading maka gambar ini yang di tampilkan
            .error(R.drawable.ic_home)
            .into(holder.imgWisata)

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val i = Intent(context, DetailWisataActivity::class.java)
            i.putExtra("WST", listWisata?.get(position))
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        if (listWisata != null){
            return listWisata!!.size
        }else{
            return 0
        }
    }


}