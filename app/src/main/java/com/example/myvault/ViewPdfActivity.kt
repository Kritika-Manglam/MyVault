package com.example.myvault

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class ViewPdfActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private var pdfReference = Firebase.storage.reference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_view_pdf)

            // Find the WebView by its unique ID
            val webView = findViewById<WebView>(R.id.web)
            val url=pdfReference.child("pdf").downloadUrl
            // loading http://www.google.com url in the WebView.
            webView.loadUrl("url")

            // this will enable the javascript.
            webView.settings.javaScriptEnabled = true

            // WebViewClient allows you to handle
            // onPageFinished and override Url loading.
            webView.webViewClient = WebViewClient()
        }
    }


