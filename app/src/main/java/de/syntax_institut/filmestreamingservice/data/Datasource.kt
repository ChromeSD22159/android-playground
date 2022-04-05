package de.syntax_institut.filmestreamingservice.data

import android.content.Context
import de.syntax_institut.filmestreamingservice.data.model.Movie
import kotlin.random.Random

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val nrOfImages = 14 // anpassen, wenn Anzahl an Bildern geändert wurde
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
            val image = getImage()

            // Füge ein Movie Objekt hinzu
            movies.add(

                Movie(title, image)

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

    private var iPrevious = 0
    /**
     * Diese Funktion liefert ein zufälliges Bild aus der Bilderquelle
     */
    private fun getImage(): Int {
        var i: Int
        // kein Bild soll zweimal hintereinander kommen
        while (true) {
            i = Random.nextInt(1, nrOfImages + 1)
            if (iPrevious != i) {
                iPrevious = i
                break
            }
        }
        // Liefere das entsprechende Bild aus der Quelle
        return context.resources.getIdentifier(
            "film_$i",
            "drawable",
            context.packageName
        )
    }
}
