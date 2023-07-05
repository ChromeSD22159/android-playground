package de.syntax_institut.filmestreamingservice.data
import de.syntax_institut.filmestreamingservice.R
import de.syntax_institut.filmestreamingservice.data.model.Movie

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource{

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadMovies(): List<Movie> {
        return mutableListOf(
            Movie(R.string.movieTitle1, false),
            Movie(R.string.movieTitle2, false),
            Movie(R.string.movieTitle3, false),
            Movie(R.string.movieTitle4, false),
            Movie(R.string.movieTitle5, false),
            Movie(R.string.movieTitle6, false),
            Movie(R.string.movieTitle7, false),
            Movie(R.string.movieTitle8, false),
            Movie(R.string.movieTitle9, false),
            Movie(R.string.movieTitle10, false),
            Movie(R.string.movieTitle11, false),
            Movie(R.string.movieTitle12, false),
            Movie(R.string.movieTitle13, false),
            Movie(R.string.movieTitle14, false),
            Movie(R.string.movieTitle15, false),
            Movie(R.string.movieTitle16, false),
            Movie(R.string.movieTitle17, false),
            Movie(R.string.movieTitle18, false),
            Movie(R.string.movieTitle19, false),
            Movie(R.string.movieTitle20, false),
            Movie(R.string.movieTitle21, false),
            Movie(R.string.movieTitle22, false),
            Movie(R.string.movieTitle23, false),
            Movie(R.string.movieTitle24, false),
            Movie(R.string.movieTitle25, false),
            Movie(R.string.movieTitle26, false),
            Movie(R.string.movieTitle27, false),
            Movie(R.string.movieTitle28, false),
            Movie(R.string.movieTitle29, false),
            Movie(R.string.movieTitle30, false),
        )
    }
}
