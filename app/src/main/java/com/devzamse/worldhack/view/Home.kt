package com.devzamse.worldhack

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devzamse.worldhack.`interface`.RecyclerInterface
import com.devzamse.worldhack.presenter.HomeCustom
import com.devzamse.worldhack.presenter.Homes
import kotlinx.android.synthetic.*

class Home : Fragment() {

    var lista: RecyclerView? = null
    var adaptador: HomeCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var name: String
    private lateinit var foto: String
    private lateinit var imagen: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //extras
        foto = arguments?.getString("foto").toString()
        imagen = view.findViewById(R.id.perfil)
        Glide.with(view).load(foto).into(imagen)

        name = arguments?.getString("name").toString()
        val textView: TextView = view.findViewById(R.id.textView)
        textView.text = "Hi $name,\nSpecial books\nfor you and you mind"

        Log.e("foto", foto)
        Log.e("name", name)

        //inflate
        lista = view.findViewById(R.id.recycler)
        lista?.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        lista?.layoutManager = layoutManager

        val recyclerss = ArrayList<Homes>()

        adaptador = HomeCustom(recyclerss, object : RecyclerInterface {
            override fun onClick(vista: View, index: Int) {
                val intent = Intent(context, InfoPage::class.java)
                intent.putExtra("title", recyclerss.get(index).title)
                intent.putExtra("sub", recyclerss.get(index).sub)
                intent.putExtra("imagen", recyclerss.get(index).imagen)
                startActivity(intent)
            }
        })

        lista?.adapter = adaptador

        AddLista(recyclerss)

        val constraintLayout2: VideoView = view.findViewById(R.id.constraintLayout2)
        constraintLayout2.setVideoURI(Uri.parse("https://r4---sn-n4v7sney.googlevideo.com/videoplayback?expire=1590873865&ei=qXrSXpmFL8eR-gbZ64_4Dw&ip=45.72.113.95&id=o-AOsQpi0htMhwctaztH40QgnDssqUpSenf96VwD00aer5&itag=18&source=youtube&requiressl=yes&mh=ms&mm=31%2C29&mn=sn-n4v7sney%2Csn-n4v7knll&ms=au%2Crdu&mv=m&mvi=3&pl=23&initcwndbps=16165000&vprv=1&mime=video%2Fmp4&gir=yes&clen=18550805&ratebypass=yes&dur=347.695&lmt=1541006278493573&mt=1590852155&fvip=4&fexp=23882514&c=WEB&txp=5431432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgbiZCwkrqoJX4NNb3sQAjosYxfRLeS251_BTCVoufI28CIH81FW49bBzuIaACvH9AgW3nHnHQ2P8X4raKKoxe4wNq&sig=AOq0QJ8wRQIhALS9wEtjUNtZyOa2DneBk5eHL0WfvmnfzU5g4ixCHdbTAiB6rpfTFrdeDEVCbWeq5leuuZfe0eDIip_Wg4cDuWHxVQ%3D%3D&video_id=upJwpiVHWD8&title=I+JUST+SUED+THE+SCHOOL+SYSTEM+%5BDoblaje+Español%5D"))
        constraintLayout2.requestFocus()
        constraintLayout2.start()

        return view
    }

    private fun AddLista(recyclers: ArrayList<Homes>) {
        recyclers.add(Homes(R.drawable.hoobit, "Adventure", "The Hoobit"))
        recyclers.add(Homes(R.drawable.sthepen, "Thriller", "The Institute"))
        recyclers.add(Homes(R.drawable.gritty, "Drama", "The Great Gripsy"))
    }

}
