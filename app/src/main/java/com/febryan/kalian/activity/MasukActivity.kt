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
import kotlinx.android.synthetic.main.activity_masuk.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MasukActivity : AppCompatActivity() {

    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        sharedPreference = SharedPreference(this)

        btn_masuk.setOnClickListener {
            masukYuk()
        }

    }

    private fun masukYuk() {
        val email = edt_email.text.toString()
        val pass = edt_pass.text.toString()

        if (email.isEmpty()){
            edt_email.error = "Isi dulu emailnya!"
            return
        }

        if (pass.isEmpty()){
            edt_pass.error = "Isi dulu password !"
            return
        }

        pb.visibility = View.VISIBLE

        ApiConfig.instanceRetrofit.loginYuk(email, pass).enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {

                pb.visibility = View.GONE
                val respon = response.body()
                if (respon != null){
                    if (respon.status == 0){
                        Toast.makeText(this@MasukActivity, respon.message, Toast.LENGTH_SHORT).show()
                    }else{
                        sharedPreference.setStatusLogin(true)
                        startActivity(Intent(this@MasukActivity, MainActivity::class.java))
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@MasukActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}