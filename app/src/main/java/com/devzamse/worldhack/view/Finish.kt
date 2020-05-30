package com.devzamse.worldhack.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.devzamse.worldhack.MainActivity
import com.devzamse.worldhack.R

class Finish : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val stringAutor = intent.getStringExtra("author")
        val image = intent.getIntExtra("foto", 0)
        val imagens = resources.getDrawable(image)

        val foto: ImageView = findViewById(R.id.imageView4)
        val titulo: TextView = findViewById(R.id.textView17)


        foto.setImageDrawable(imagens)
        titulo.text = stringAutor


        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}
