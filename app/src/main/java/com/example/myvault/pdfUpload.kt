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
            database.child(pdfName).setValue(user).addOnSuccessListener {
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
                //this line of code will be used to upload the file
                //pathstring is where we want to upload the file
                //in our case images
                //nut before that lets create that images path on our
                pdfReference.child("pdf/$filename").putFile(it).addOnSuccessListener {
                    Toast.makeText(this,"Success upload", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this,"Error On Upload", Toast.LENGTH_SHORT).show()
                }


            }}
        catch(e:Exception)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }


    }





}
// lateinit var binding: ActivityPdfUploadBinding
// lateinit var PdfUri : Uri
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// binding= ActivityPdfUploadBinding.inflate(layoutInflater)
// setContentView(binding.root)
// binding.selectPdf.setOnClickListener{
// selectPdf()
// }
// binding.btn.setOnClickListener{
// uploadPdf()
// }
// }
//
// private fun uploadPdf() {
// val progressDialog=ProgressDialog(this)
// progressDialog.setMessage("Uploading file")
// progressDialog.setCancelable(false)
// progressDialog.show()
// val formatter=SimpleDateFormat("yyyy_MM_dd_HH_mm_ss",Locale.getDefault())
// val now= Date()
// val fileName=formatter.format(now)
// val storageReference=FirebaseStorage.getInstance().getReference("pdf/$fileName")
// storageReference.putFile(PdfUri).addOnSuccessListener {
// //binding.firebasePdf.setPdfURI(null)
// //  Toast.makeText(this@StorageActivity,"Success", Toast.LENGTH_SHORT).show()
// if(progressDialog.isShowing)progressDialog.dismiss()
// }.addOnFailureListener{
// if(progressDialog.isShowing)progressDialog.dismiss()
// //  Toast.makeText(this@StorageAActivity,"Failed",Toast.LENGTH_SHORT).show()
// }
// }
//
// private fun selectPdf() {
//
// val intent=Intent()
// intent.type="pdf/*"
// intent.action= Intent.ACTION_GET_CONTENT
// startActivityForResult(intent,100)
//
// }
//
// override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
// super.onActivityResult(requestCode, resultCode, data)
// if(requestCode==100&&resultCode== RESULT_OK){
// PdfUri=data?.data!!
// //binding.firebasePdf.setPdfURI(PdfUri)
// }
// }
// }
//
//
//
// }*