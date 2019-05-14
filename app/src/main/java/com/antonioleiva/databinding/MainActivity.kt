package com.antonioleiva.databinding

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress.visibility = View.GONE

        button.setOnClickListener {
            onLoginClicked(user.text.toString(), pass.text.toString())
        }
    }

    private fun onLoginClicked(user: String, pass: String) {
        progress.visibility = View.VISIBLE
        handler.postDelayed({
            val result = if(user.isNotEmpty() && pass.isNotEmpty()) "Success" else "Failure"
            message.text = result
            progress.visibility = View.GONE
        }, 2000)
    }
}
