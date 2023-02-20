package de.syntax_institut.filmestreamingservice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import de.syntax_institut.filmestreamingservice.adapter.ItemAdapter
import de.syntax_institut.filmestreamingservice.data.Datasource
import de.syntax_institut.filmestreamingservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * Die lifecycle onCreate Methode
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Liste aus Filmtiteln wird von der Datasource geladen
        val movieTitles = Datasource(this).loadMovies()

        // recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.recyclerView

        // recyclerView erhält einen passenden LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ItemAdapter wird als Adapter festgelegt
        recyclerView.adapter = ItemAdapter(this, movieTitles)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)
    }
}