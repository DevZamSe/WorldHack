package com.devzamse.worldhack

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.OnCompleteListener


class Profile : Fragment() {

    private lateinit var atras: ImageView
    private lateinit var logOut: Button
    private var mGoogleSignInClient: GoogleSignInClient?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        //extras
        val foto = arguments?.getString("foto").toString()
        val imagen: ImageView = view.findViewById(R.id.fotoPerfil)
        Glide.with(view).load(foto).into(imagen)

        val name = arguments?.getString("name").toString()
        val textView: TextView = view.findViewById(R.id.names)
        textView.text = name

        val ids = arguments?.getString("id").toString()
        val id: TextView = view.findViewById(R.id.id)
        id.text = "ID $ids"

        val mail = arguments?.getString("email").toString()
        val mails: TextView = view.findViewById(R.id.mails)
        mails.text = mail

        atras = view.findViewById(R.id.atras)
        atras.setOnClickListener {
            val i = Intent(context, MainActivity::class.java)
            startActivity(i)
        }

        logOut = view.findViewById(R.id.button)
        logOut.setOnClickListener {
            signOut()
        }



        return view
    }

    private fun signOut() {
        mGoogleSignInClient!!.signOut().addOnCompleteListener(activity!!, OnCompleteListener<Void?> {
                startActivity(Intent(context, Splash::class.java))
                activity!!.finish()
            })
    }

}
