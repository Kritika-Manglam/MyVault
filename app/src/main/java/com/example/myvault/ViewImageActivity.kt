package com.example.myvault

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myvault.databinding.ActivityViewImageBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class ViewImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityViewImageBinding
    private var imageReference = Firebase.storage.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewImageBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_view_image)
        setContentView(binding.root)
          // finding img view
        val imageView : ImageView=findViewById(R.id.imageView11)
        // setting url
        val imgurl=imageReference.child("Images").downloadUrl
        //val url ="gs://my-vault-8e11d.appspot.com/Images"
       //val url="https://picsum.photos/300"
        Glide.with(this).load(imgurl).into(binding.imageView11)


}}