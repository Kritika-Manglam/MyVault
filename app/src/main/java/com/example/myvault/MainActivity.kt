
package com.example.myvault

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun appBegins(view: View) {
        Toast.makeText(this,"Let's Begin",Toast.LENGTH_LONG).show()
        val intent = Intent(this, LoginPageActivity::class.java)
        startActivity(intent)
    }

}