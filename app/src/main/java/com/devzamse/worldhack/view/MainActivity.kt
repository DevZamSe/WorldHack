package com.devzamse.worldhack

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.devzamse.worldhack.view.Favorites

class MainActivity : AppCompatActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView
    private lateinit var frame: FrameLayout
    private lateinit var centerbotom: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initVar
        frame = findViewById(R.id.frame)
        home = findViewById(R.id.home)
        profile = findViewById(R.id.profile)
        centerbotom = findViewById(R.id.centerbotom)

        //ContentView
        val frag: Fragment = Home()
        val fragMan: FragmentManager = supportFragmentManager
        val fragTran: FragmentTransaction = fragMan.beginTransaction()

        fragTran.replace(R.id.frame, frag)
        fragTran.addToBackStack(null)
        fragTran.commit()

        OnClickEvents(home, profile, centerbotom)

    }

    @SuppressLint("NewApi")
    private fun OnClickEvents(home: ImageView?, profile: ImageView?, centerbotom: ConstraintLayout) {
        home?.setOnClickListener{
            //ContentView
            val frag: Fragment = Favorites()
            val fragMan: FragmentManager = supportFragmentManager
            val fragTran: FragmentTransaction = fragMan.beginTransaction()

            fragTran.replace(R.id.frame, frag)
            fragTran.addToBackStack(null)
            fragTran.commit()

            home.setColorFilter(getColor(R.color.red))
            profile?.setColorFilter(getColor(R.color.plomo))
        }

        profile?.setOnClickListener{
            //ContentView
            val frag: Fragment = Profile()
            val fragMan: FragmentManager = supportFragmentManager
            val fragTran: FragmentTransaction = fragMan.beginTransaction()

            fragTran.replace(R.id.frame, frag)
            fragTran.addToBackStack(null)
            fragTran.commit()

            home?.setColorFilter(getColor(R.color.plomo))
            profile.setColorFilter(getColor(R.color.red))
        }

        centerbotom.setOnClickListener {
            //ContentView
            val frag: Fragment = Home()
            val fragMan: FragmentManager = supportFragmentManager
            val fragTran: FragmentTransaction = fragMan.beginTransaction()

            fragTran.replace(R.id.frame, frag)
            fragTran.addToBackStack(null)
            fragTran.commit()

            home?.setColorFilter(getColor(R.color.plomo))
            profile?.setColorFilter(getColor(R.color.plomo))
        }
    }
}
