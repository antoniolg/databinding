package com.antonioleiva.databinding

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.antonioleiva.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val handler = Handler()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.visible = false
        binding.handlers = this
    }

    fun onLoginClicked(user: String, pass: String) {
        binding.visible = true
        handler.postDelayed({
            val result = if(user.isNotEmpty() && pass.isNotEmpty()) "Success" else "Failure"
            binding.infoMessage = result
            binding.visible = false
        }, 2000)
    }
}
