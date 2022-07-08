package com.febryan.kalian.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.febryan.kalian.R
import com.febryan.kalian.api.ApiConfig
import com.febryan.kalian.helper.SharedPreference
import com.febryan.kalian.model.ResponseUser
import kotlinx.android.synthetic.main.activity_daftar.*
import kotlinx.android.synthetic.main.activity_masuk.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        sharedPreference = SharedPreference(this)

//        btn_daftar.setOnClickListener {
//            daftar()
//        }

    }

//    private fun daftar() {
//
//        val name = edt_name_regis.text.toString()
//        val email = edt_email_regis.text.toString()
//        val phone = edt_phone_regis.text.toString()
//        val city = edt_city_regis.text.toString()
//        val pass = edt_pass_regis.text.toString()
//
//        if (name.isEmpty()){
//            edt_name_regis.error = "Isi dulu namanya!"
//            return
//        }
//
//        if (email.isEmpty()){
//            edt_email_regis.error = "Isi dulu emailnya!"
//            return
//        }
//
//        if (phone.isEmpty()){
//            edt_phone_regis.error = "Isi dulu teleponnya !"
//            return
//        }
//
//        if (city.isEmpty()){
//            edt_city_regis.error = "Isi dulu kotanya !"
//            return
//        }
//
//        if (pass.isEmpty()){
//            edt_pass_regis.error = "Isi dulu passwordnya !"
//            return
//        }
//
//        pb_regis.visibility = View.VISIBLE
//
//        ApiConfig.instanceRetrofit.regisYuk(name,email,phone,pass,city).enqueue(object : Callback<ResponseUser>{
//            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
//                pb_regis.visibility = View.GONE
//                val respon = response.body()
//                if (respon != null){
//                    if (respon.status == 0){
//                        Toast.makeText(this@DaftarActivity, respon.message, Toast.LENGTH_SHORT).show()
//                    }else{
//                        sharedPreference.setStatusLogin(true)
//                        startActivity(Intent(this@DaftarActivity, MainActivity::class.java))
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
//                pb_regis.visibility = View.GONE
//                Toast.makeText(this@DaftarActivity, t.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}