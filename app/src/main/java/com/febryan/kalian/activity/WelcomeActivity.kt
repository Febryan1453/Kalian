package com.febryan.kalian.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.febryan.kalian.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        mainButton()

    }

    private fun mainButton() {
        btn_login.setOnClickListener {
            val i = Intent(this@WelcomeActivity, MasukActivity::class.java)
            startActivity(i)
        }

        btn_regis.setOnClickListener {
            val i = Intent(this@WelcomeActivity, RegistrasiActivity::class.java)
            startActivity(i)
        }
    }
}