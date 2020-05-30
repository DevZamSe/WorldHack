package com.devzamse.worldhack

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devzamse.worldhack.`interface`.RecyclerInterface
import com.devzamse.worldhack.presenter.HomeCustom
import com.devzamse.worldhack.presenter.Homes

class Home : Fragment() {

    var lista: RecyclerView? = null
    var adaptador: HomeCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

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

        return view
    }

    private fun AddLista(recyclers: ArrayList<Homes>) {
        recyclers.add(Homes(R.drawable.ic_launcher_background, "titulo", "subtitlo"))
        recyclers.add(Homes(R.drawable.ic_launcher_background, "titulo", "subtitlo"))
        recyclers.add(Homes(R.drawable.ic_launcher_background, "titulo", "subtitlo"))
        recyclers.add(Homes(R.drawable.ic_launcher_background, "titulo", "subtitlo"))
    }

}
