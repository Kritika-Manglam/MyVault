package com.example.myvault

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterpdf(private val userList : ArrayList<pdfItem>) : RecyclerView.Adapter<adapterpdf.MyViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item_pdf,
                parent,false)
            return MyViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            val currentItem = userList[position]

            holder.firstName.text = currentItem.pdfName
            holder.lastName.text = currentItem.pdfExtension
            holder.age.text = currentItem.pdfURL
            var uri=currentItem.pdfURL.toString()
           // Glide.with(holder.itemViews.context).load(uri).into(holder.itemViews)
          //  holder.pdfView.fromAsset(uri)
            holder.webView.loadUrl(uri)
          //  holder.webView.settings.javaScriptEnabled = true
          //  holder.webView.webViewClient = WebViewClient()
            //for intent
//            holder.itemView.setOnClickListener {
////
////            var intent= Intent(this@adapterpdf, ViewPdfActivity::class.java)
////         intent.putExtra(MyPDFs[position].pdfURL)
////            startActivity(intent)
//
//        }
    }

        override fun getItemCount(): Int {

            return userList.size
        }


        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            //val itemViews : ImageView = itemView.findViewById(R.id.imageView3)
            val firstName : TextView = itemView.findViewById(R.id.tvpdfName)
            val lastName : TextView = itemView.findViewById(R.id.tvpdfext)
            val age : TextView = itemView.findViewById(R.id.tvurl)
           // val pdfView :PDFView =itemView.findViewById(R.id.pdfView12)
            val webView : WebView =itemView.findViewById(R.id.web12)

        }

    }
