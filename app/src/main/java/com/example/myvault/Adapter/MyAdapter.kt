package com.example.myvault.Adapter
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myvault.Fragments.MyImages
import com.example.myvault.Fragments.MyPDFs

internal class MyAdapter (var context:Context,fm:FragmentManager,var totalTabs:Int):FragmentPagerAdapter(fm)
{
    override fun getItem(position:Int): Fragment {
        return when (position) {
             0 -> {
                MyPDFs()
            }
            1 -> {
                MyImages()

            }

        else-> getItem(position)
    }
    }
    override fun getCount():Int {
        return totalTabs
    }
}