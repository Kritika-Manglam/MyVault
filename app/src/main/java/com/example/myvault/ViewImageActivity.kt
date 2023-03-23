package com.example.myvault

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myvault.databinding.ActivityViewImageBinding


class ViewImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityViewImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewImageBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_view_image)
        setContentView(binding.root)
          // finding img view
        val imageView : ImageView=findViewById(R.id.imageView11)
        // setting url
        val url ="gs://my-vault-8e11d.appspot.com/Images"
       // val url="https://picsum.photos/300"
        Glide.with(this).load(url).into(binding.imageView11)

   // ImageView imageView = (ImageView) findViewById(R.id.imageView);

   // Glide.with(context)

    //.load("YOUR IMAGE URL HERE")

    //.into(imageView)

    //.error(R.drawable.imagenotfound);
}}