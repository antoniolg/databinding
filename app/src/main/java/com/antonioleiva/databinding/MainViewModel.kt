package com.antonioleiva.databinding

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val handler = Handler()

    private val _progressVisible = MutableLiveData<Boolean>()
    val progressVisible: LiveData<Boolean> get() = _progressVisible

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    fun onLoginClicked(user: String, pass: String) {
        _progressVisible.value = true
        handler.postDelayed({
            val result = if (user.isNotEmpty() && pass.isNotEmpty()) "Success" else "Failure"
            _message.value = result
            _progressVisible.value = false
        }, 2000)
    }


}