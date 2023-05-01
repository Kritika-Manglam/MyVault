
package com.example.myvault

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch :Switch = findViewById (R.id.switch1)
        switch.setOnCheckedChangeListener{ buttonView,isChecked ->
            if(isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }

    fun appBegins(view: View) {
        Toast.makeText(this,"Let's Begin",Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginPageActivity::class.java)
        startActivity(intent)
    }


}