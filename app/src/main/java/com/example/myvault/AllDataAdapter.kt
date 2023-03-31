package com.example.myvault


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage



class AllDataAdapter(private val MyImages : ArrayList<itemDs>) : RecyclerView.Adapter<AllDataAdapter.MyViewHolder>() {

    private var imageReference = Firebase.storage.reference
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = MyImages[position]

        holder.firstName.text = currentItem.imgName
        holder.lastName.text = currentItem.fileExtension
       holder.age.text = currentItem.ImgURL



        val uri=currentItem.ImgURL
        Glide.with(holder.itemViews1.context).load(uri).into(holder.itemViews1)

//        holder.itemView.setOnClickListener {
//
//            val intent= Intent(this@AllDataAdapter, ViewImageActivity::class.java)
//            intent.putExtra("ImgNAME",MyImages[position])
//            startActivity(intent)
//        }

    }




    override fun getItemCount(): Int {

        return MyImages.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

       val itemViews1 : ImageView = itemView.findViewById(R.id.imageView)
        val firstName : TextView = itemView.findViewById(R.id.tvfirstName)
        val lastName : TextView = itemView.findViewById(R.id.tvlastName)
        val age : TextView = itemView.findViewById(R.id.tvage)

    }

}