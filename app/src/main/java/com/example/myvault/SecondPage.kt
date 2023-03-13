package com.example.myvault

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myvault.Adapter.MyAdapter
import com.google.android.material.tabs.TabLayout

class SecondPage : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager= findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("My PDFs"))
        tabLayout.addTab(tabLayout.newTab().setText("My Images"))
        //tabLayout.tabGravity = TableLayout.GRAVITY_FILL

        val adapter=MyAdapter(this,supportFragmentManager,tabLayout.tabCount)
        viewPager.adapter=adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab:TabLayout.Tab?){
                viewPager.currentItem=tab!!.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab?){}
            override fun onTabReselected(tab: TabLayout.Tab?){}
        })

    }

}