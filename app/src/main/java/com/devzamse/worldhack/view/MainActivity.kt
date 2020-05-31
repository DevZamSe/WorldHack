package com.devzamse.worldhack

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.devzamse.worldhack.view.Favorites
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class MainActivity : AppCompatActivity() {

    private lateinit var home: ImageView
    private lateinit var profile: ImageView
    private lateinit var frame: FrameLayout
    private var count: Int = 0
    private lateinit var personName: String
    private lateinit var personEmail: String
    private lateinit var personId: String
    private lateinit var personPhoto: String
    private lateinit var centerbotom: ConstraintLayout
    private var mGoogleSignInClient: GoogleSignInClient?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ExtraGoogleLogin
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            personName = acct.displayName!!
            personEmail = acct.email!!
            personId = acct.id!!
            personPhoto = acct.photoUrl.toString()

            Log.e("name", personName)
            Log.e("mail", personEmail)
            Log.e("name", personId)
            Log.e("name", personPhoto)
        }

        //initVar
        frame = findViewById(R.id.frame)
        home = findViewById(R.id.home)
        profile = findViewById(R.id.profile)
        centerbotom = findViewById(R.id.centerbotom)

        //ContentView
        val frag: Fragment = Home()
        val fragMan: FragmentManager = supportFragmentManager
        val fragTran: FragmentTransaction = fragMan.beginTransaction()

        val args = Bundle()
        args.putString("name", personName)
        args.putString("foto", personPhoto)
        frag.arguments = args

        fragTran.replace(R.id.frame, frag)
        fragTran.addToBackStack(null)
        fragTran.commit()

        OnClickEvents(home, profile, centerbotom)

    }

    @SuppressLint("NewApi")
    private fun OnClickEvents(home: ImageView?, profile: ImageView?, centerbotom: ConstraintLayout) {
        home?.setOnClickListener{
            //ContentView
            count += 1
            if(count == 1){
                val frag: Fragment = Favorites()
                val fragMan: FragmentManager = supportFragmentManager
                val fragTran: FragmentTransaction = fragMan.beginTransaction()

                val args = Bundle()
                args.putString("cuenta","1")
                frag.arguments = args

                fragTran.replace(R.id.frame, frag)
                fragTran.addToBackStack(null)
                fragTran.commit()
            } else{

                val frag: Fragment = Favorites()
                val fragMan: FragmentManager = supportFragmentManager
                val fragTran: FragmentTransaction = fragMan.beginTransaction()

                val args = Bundle()
                args.putString("cuenta","2")
                frag.arguments = args

                fragTran.replace(R.id.frame, frag)
                fragTran.addToBackStack(null)
                fragTran.commit()
            }

            home.setColorFilter(getColor(R.color.red))
            profile?.setColorFilter(getColor(R.color.plomo))
        }

        profile?.setOnClickListener{
            //ContentView
            val frag: Fragment = Profile()
            val fragMan: FragmentManager = supportFragmentManager
            val fragTran: FragmentTransaction = fragMan.beginTransaction()

            val args = Bundle()
            args.putString("name", personName)
            args.putString("email", personEmail)
            args.putString("id", personId)
            args.putString("foto", personPhoto)

            frag.arguments = args

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

            val args = Bundle()
            args.putString("name", personName)
            args.putString("foto", personPhoto)
            frag.arguments = args

            fragTran.replace(R.id.frame, frag)
            fragTran.addToBackStack(null)
            fragTran.commit()

            home?.setColorFilter(getColor(R.color.plomo))
            profile?.setColorFilter(getColor(R.color.plomo))
        }
    }

    override fun onBackPressed() {
        Log.e("atras","nel")
    }
}
