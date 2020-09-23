package com.example.lab1.view

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.R

class CatchIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch_intent)

        val webViewCatch = findViewById<WebView>(R.id.webView_catch)

        val intent = intent
        val link: String? = intent.dataString
        if (link != null) {
            webViewCatch.loadUrl(link)
        }

    }
}