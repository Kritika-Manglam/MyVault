package com.example.myvault


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myvault.databinding.ActivityPdfUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class pdfUpload : AppCompatActivity() {
    private lateinit var binding: ActivityPdfUploadBinding
    private var pdfReference = Firebase.storage.reference
    private var currentFile: Uri? = null
    private lateinit var database: DatabaseReference
    val key=System.currentTimeMillis().toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set view binding
        binding = ActivityPdfUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_image_upload)
        binding.pdfView.setOnClickListener {
            //open storage / pdf
            Intent(Intent.ACTION_GET_CONTENT).also {
                //filter pdf only
                it.type = "application/pdf"
                pdfLauncher.launch(it)
            }
        }
        binding.btn.setOnClickListener{
            uploadImageTostorage("1")
            //realtime database
            val pdfName=binding.Txt2.text.toString()
            database=FirebaseDatabase.getInstance().getReference("pdfItem")
            val user=pdfItem(pdfName)
            database.child(key).setValue(user).addOnSuccessListener {
                binding.Txt2.text.clear()
                Toast.makeText(this,"Successfully loaded",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
            }
        }
    }


    private val pdfLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result?.data?.data?.let {
                    currentFile = it
                    binding.pdfView.setImageURI(it)
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


                pdfReference.child("pdf/$filename").putFile(it).addOnSuccessListener {
                    pdfReference.child("pdf/$filename").downloadUrl.addOnSuccessListener {
                        database = FirebaseDatabase.getInstance().getReference("pdfItem")
                        //val key=System.currentTimeMillis().toString()
                        database.child(key).child("pdfURL").setValue(it.toString())
                    }
                    Toast.makeText(this,"Success upload", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this,"Error On Upload", Toast.LENGTH_SHORT).show()
                }


            }}
        catch(e:Exception)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }


    }}




