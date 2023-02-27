package de.syntax_institut.filmestreamingservice.data

import android.content.Context
import android.util.Log
import de.syntax_institut.filmestreamingservice.data.model.Movie

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val numberOfTitles = 30 // anpassen, wenn Anzahl an Filmtiteln geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadMovies(): List<Movie> {
        // Die Liste an Filmen
        val movies = mutableListOf<Movie>()

        // Befülle die Liste
        for (index in 1..numberOfTitles) {

            // Hole den Titel und das Bild
            val title = getTitle(index)

            // Füge ein Movie Objekt hinzu
            movies.add(

                Movie(title, false)

            )
        }
        return movies
    }

    /**
     * Diese Funktion liefert den Titel Nummer index aus der Quelle
     */
    private fun getTitle(index: Int): Int {
        return context.resources.getIdentifier(
            "movieTitle$index",
            "string",
            context.packageName
        )
    }
}
