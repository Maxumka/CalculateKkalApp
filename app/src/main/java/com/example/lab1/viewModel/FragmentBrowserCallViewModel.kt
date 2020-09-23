package com.example.lab1.viewModel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class FragmentBrowserCallViewModel(app: Application): AndroidViewModel(app) {

    private val context = getApplication<Application>().applicationContext

    private var _link = MutableLiveData<String>()
    val mLink: MutableLiveData<String> = _link

    fun openLink() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse(mLink.value)
        context.startActivity(intent)
    }
}