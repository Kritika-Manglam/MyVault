package com.example.myvault

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.net.URLEncoder


class ViewPdfActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private var pdfReference = Firebase.storage.reference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_view_pdf)


            val webView = findViewById<WebView>(R.id.web)



            val fileurl:String =  intent.getStringExtra("pdfURL").toString()


            webView.settings.javaScriptEnabled = true


            webView.webViewClient = WebViewClient()



                val url= URLEncoder.encode(fileurl,"UTF-8").toString()


            webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+url)
           
        }
    }


