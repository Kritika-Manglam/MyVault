package com.example.myvault.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myvault.R
import com.example.myvault.databinding.FragmentMyPdfsBinding
import com.example.myvault.pdfUpload


class MyPDFs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMyPdfsBinding.inflate(inflater,container,false)
        binding.a2.setOnClickListener{
            startActivity(Intent(binding.root.context, pdfUpload::class.java))
        }
        return binding.root


        return inflater.inflate(R.layout.`fragment_my_pdfs`, container, false)
    }}

