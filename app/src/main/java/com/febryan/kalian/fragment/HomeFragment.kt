package com.febryan.kalian.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.febryan.kalian.R
import com.febryan.kalian.adapter.AdapterNamaKategori
import com.febryan.kalian.adapter.AdapterSlider
import com.febryan.kalian.adapter.AdapterWisata
import com.febryan.kalian.api.ApiConfig
import com.febryan.kalian.databinding.FragmentHomeBinding
import com.febryan.kalian.model.ResponseKategori
import com.febryan.kalian.model.ResponseWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.appcompat.app.AppCompatActivity




class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvWisata: RecyclerView
    lateinit var rvNamaKategori: RecyclerView
    lateinit var sRLoading: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        vpSlider = view.findViewById(R.id.vp_slider)
        rvWisata = view.findViewById(R.id.rv_wisata)
        rvNamaKategori = view.findViewById(R.id.rv_nama_kategori)
        sRLoading = view.findViewById(R.id.srl_loading)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.carousel2)
        arrSlider.add(R.drawable.carousel3)
        arrSlider.add(R.drawable.carousel4)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        getDataWisata()
        getNamaKategori()
        sRefreshLoading()

        return view
    }

    private fun sRefreshLoading() {
        sRLoading.setOnRefreshListener {
            getDataWisata()
            getNamaKategori()
            sRLoading.isRefreshing = false
        }
    }

    private fun getNamaKategori() {
        ApiConfig.instanceRetrofit.getKategoriWisata().enqueue(object : Callback<ResponseKategori>{
            override fun onResponse(call: Call<ResponseKategori>, response: Response<ResponseKategori>) {
                if (response.isSuccessful){
                    val responseKategori = response.body()
                    val kategori = responseKategori?.data
                    val adapterNamaKategori = AdapterNamaKategori(kategori)
                    rvNamaKategori.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                        adapterNamaKategori.notifyDataSetChanged()
                        adapter = adapterNamaKategori
                    }
                }
            }

            override fun onFailure(call: Call<ResponseKategori>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun getDataWisata() {

        ApiConfig.instanceRetrofit.getWisata().enqueue(object : Callback<ResponseWisata>{

            override fun onResponse(call: Call<ResponseWisata>, response: Response<ResponseWisata>) {

                if (response.isSuccessful){

                    val responseWisata = response.body()
                    val wisata = responseWisata?.data
                    val adapterWisata = AdapterWisata(wisata)

                    rvWisata.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
                        adapterWisata.notifyDataSetChanged()
                        adapter = adapterWisata
                    }
                }
            }

            override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

}