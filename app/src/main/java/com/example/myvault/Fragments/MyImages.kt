package com.example.myvault.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myvault.AllDataAdapter
import com.example.myvault.ImageUpload
import com.example.myvault.databinding.FragmentMyImagesBinding
import com.example.myvault.itemDs
import com.google.firebase.database.DatabaseReference


class MyImages : Fragment() {
    //recycler
    private lateinit var adapter : AllDataAdapter
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var newsArrayList: ArrayList<itemDs>
   // private lateinit var imgName : Array<String>
    //private lateinit var news :Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        // Inflate the layout for this fragment
        val binding = FragmentMyImagesBinding.inflate(inflater, container, false)
        binding.a1.setOnClickListener {
            startActivity(Intent(binding.root.context, ImageUpload::class.java))
        }
        return binding.root
    }
//   override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        onCreateView(MyImages)
//
//       userRecyclerview= findViewById(R.id.recycler_view)
//        userRecyclerview.layoutManager = LinearLayoutManager(this)
//        userRecyclerview.setHasFixedSize(true)
//
//        newsArrayList= arrayListOf<itemDs>()
//        getUserData()
//    }
//
//
//
//
//
//
//    private fun getUserData() {
//       dbref= FirebaseDatabase.getInstance().getReference("IMAGES")
//       dbref.addValueEventListener(object: ValueEventListener {
//      override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    for(userSnapshot in snapshot.children){
//                        val user= userSnapshot.getValue(itemDs::class.java)
//                        newsArrayList.add(user!!)
//                    }
//                    userRecyclerview.adapter=AllDataAdapter(newsArrayList)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        } )
//    }
//
//
//    //private fun dataInitialize() {
//     //   newsArrayList = arrayListOf<itemDs>()
    }

