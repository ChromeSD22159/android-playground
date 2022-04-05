package de.syntax_institut.filmestreamingservice.data

import android.content.Context
import de.syntax_institut.filmestreamingservice.data.model.Movie
import kotlin.random.Random

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val nrOfImages = 14 // anpassen, wenn Anzahl an Bildern geändert wurde
    private val nrOfTitles = 30 // anpassen, wenn Anzahl an Filmtiteln geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        for (i in 1..nrOfTitles) {
            movies.add(
                // Füge Movie Objekt hinzu
                Movie(
                    context.resources.getIdentifier(
                        "movieTitle$i",
                        "string",
                        context.packageName
                    ),
                    randomImage()
                )
            )
        }
        return movies
    }

    // für randomImage
    private var iPrevious = 0

    /**
     * Diese Funktion liefert ein zufälliges Bild aus der Bilderquelle
     */
    private fun randomImage(): Int {
        var i: Int
        // kein Bild soll zweimal hintereinander kommen
        while (true) {
            i = Random.nextInt(1, nrOfImages + 1)
            if (iPrevious != i) {
                iPrevious = i
                break
            }
        }
        // Liefere das entsprechende Bil aus der Quelle
        return context.resources.getIdentifier(
            "film_$i",
            "drawable",
            context.packageName
        )
    }
}
