package com.example.myvault.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myvault.R
import com.example.myvault.adapterpdf
import com.example.myvault.databinding.FragmentMyPdfsBinding
import com.example.myvault.pdfItem
import com.example.myvault.pdfUpload
import com.google.firebase.database.*




class MyPDFs : Fragment() {
    private lateinit var dbref:DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<pdfItem>
    //private lateinit var adapter : AllDataAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMyPdfsBinding.inflate(inflater, container, false)
        binding.a2.setOnClickListener {
            startActivity(Intent(binding.root.context, pdfUpload::class.java))
        }
        return binding.root


        return inflater.inflate(R.layout.`fragment_my_pdfs`, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerview= view.findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(context)
        userRecyclerview.setHasFixedSize(true)

        userArrayList= arrayListOf<pdfItem>()
        getUserData()
    }

    private fun getUserData() {
        dbref= FirebaseDatabase.getInstance().getReference("IMAGES")
        dbref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){
                        val name=userSnapshot.child("pdfName").value.toString()
                        val ext=userSnapshot.child("pdfExtension").value.toString()
                        val pdfurl=userSnapshot.child("pdfURL").value.toString()
                        userArrayList.add(pdfItem(name,ext))

                    }
                    userRecyclerview.adapter= adapterpdf(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }} )}}





