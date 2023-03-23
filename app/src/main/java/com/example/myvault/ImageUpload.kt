package com.example.myvault

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myvault.databinding.ActivityImageUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class ImageUpload : AppCompatActivity() {
    private lateinit var binding: ActivityImageUploadBinding
    private var imageReference = Firebase.storage.reference
    private var currentFile: Uri? = null
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set view binding
        binding = ActivityImageUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_image_upload)
        binding.imageView12.setOnClickListener {
            //open storage / gallery app
            Intent(Intent.ACTION_GET_CONTENT).also {
                //filter image only
                it.type = "image/*"
                imageLauncher.launch(it)
            }
        }
        binding.button2.setOnClickListener {
            uploadImageTostorage("1")
            //realtime database

            //


        }
        binding.buttong.setOnClickListener {
            val imgName = binding.Txt1.text.toString()
            val url=imageReference.downloadUrl



            database = FirebaseDatabase.getInstance().getReference("IMAGES")

            val Img = itemDs(imgName)
            database.setValue(url)
            database.child(imgName).setValue(Img).addOnSuccessListener {
                binding.Txt1.text.clear()
                Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private val imageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result?.data?.data?.let {
                    currentFile = it
                    binding.imageView12.setImageURI(it)
                }
            } else {
                //display toast message when user cancel the operation
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    private fun uploadImageTostorage(filename: String) {
        try {
            currentFile?.let {
                //to upload the file
                //pathstring is where we want to upload the file


                imageReference.child("Images/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(this, "Success upload", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Error On Upload", Toast.LENGTH_SHORT).show()
                }


            }
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}



