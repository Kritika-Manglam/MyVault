package com.example.myvault

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myvault.databinding.ActivityViewImageBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


class ViewImageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityViewImageBinding
    private var imageReference = Firebase.storage.reference
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewImageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_view_image)
        setContentView(binding.root)

       val fileurl:String = intent.getStringExtra("Imgurl").toString()




       val imageView : ImageView =findViewById(R.id.imageView11)

      Glide.with(this).load(fileurl).into(binding.imageView11)




}}