package com.devzamse.worldhack.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.devzamse.worldhack.Home
import com.devzamse.worldhack.MainActivity

import com.devzamse.worldhack.R

class Favorites : Fragment() {

    private lateinit var atras: ImageView
    private lateinit var primer: ConstraintLayout
    private lateinit var segundo: ConstraintLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        //extra Intent
        val extra = arguments!!.getString("cuenta")

        primer = view.findViewById(R.id.primer)
        segundo = view.findViewById(R.id.history)

        if(extra != "1"){
            primer.visibility = View.GONE
            segundo.visibility = View.VISIBLE
        } else {
            primer.visibility = View.VISIBLE
            segundo.visibility = View.GONE
        }

        atras = view.findViewById(R.id.atras)
        atras.setOnClickListener {
            val i = Intent(context, MainActivity::class.java)
            startActivity(i)
        }

        return view
    }

}
