package com.febryan.kalian.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.febryan.kalian.R
import com.febryan.kalian.adapter.AdapterWisata
import com.febryan.kalian.api.ApiConfig
import com.febryan.kalian.model.DataKategori
import com.febryan.kalian.model.ResponseWisata
import kotlinx.android.synthetic.main.activity_per_kategori.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerKategoriActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_per_kategori)

        kategori()
        semangat()

    }

    private fun semangat() {
        refresh.setOnRefreshListener {
            kategori()
            refresh.isRefreshing = false
        }
    }

    private fun kategori() {
        val dataKategori = intent.getParcelableExtra<DataKategori>("DTL")
        if (dataKategori != null){
            val kategori_id = dataKategori?.id
            tv_kategori_wisata.text = dataKategori.namaKategori
            getPerKatgori(kategori_id)
        }
    }

    private fun getPerKatgori(kategoriId: Int?) {
        pb_per_kategori.visibility = View.VISIBLE
        if (kategoriId != null) {
            ApiConfig.instanceRetrofit.getPerKategori(kategoriId).enqueue(object : Callback<ResponseWisata>{
                override fun onResponse(call: Call<ResponseWisata>, response: Response<ResponseWisata>) {
                    pb_per_kategori.visibility = View.GONE
                    if (response.isSuccessful){
                        val responseWisata = response.body()
                        val kategori = responseWisata?.data
                        val adapterWisata = AdapterWisata(kategori)

                        rv_per_wisata.apply {
//                            layoutManager = StaggeredGridLayoutManager(3,2)
                            layoutManager = GridLayoutManager(this@PerKategoriActivity,2)
                            setHasFixedSize(true)
                            adapter = adapterWisata
                        }

                    }
                }

                override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                    Toast.makeText(this@PerKategoriActivity,t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

}