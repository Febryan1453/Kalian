package com.febryan.kalian.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.febryan.kalian.R
import com.febryan.kalian.model.DataItem
import kotlinx.android.synthetic.main.activity_detail_wisata.*

class DetailWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        detailWisata()

    }

    private fun detailWisata() {
        val dataDetailWisata = intent.getParcelableExtra<DataItem>("WST")
        if (dataDetailWisata != null){
            tv_detai_nama_wisata.text = dataDetailWisata.namaWisata
        }
    }
}