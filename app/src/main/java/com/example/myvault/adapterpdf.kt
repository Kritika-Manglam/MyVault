package com.example.myvault

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        }

        override fun getItemCount(): Int {

            return userList.size
        }


        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            val firstName : TextView = itemView.findViewById(R.id.tvpdfName)
            val lastName : TextView = itemView.findViewById(R.id.tvpdfext)
            val age : TextView = itemView.findViewById(R.id.tvurl)

        }

    }
