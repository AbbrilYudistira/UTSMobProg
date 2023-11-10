package com.example.honkaistarrail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKarakter = findViewById(R.id.rv_karakter)
        rvKarakter.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKarakter.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListKarakterAdapter(list)
        rvKarakter.adapter = listHeroAdapter
    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Karakter> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Karakter>()
        for (i in dataName.indices) {
            val karakter = Karakter(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(karakter)
        }
        return listHero
    }


}