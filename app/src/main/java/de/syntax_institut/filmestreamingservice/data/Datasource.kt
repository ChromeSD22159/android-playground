package de.syntax_institut.filmestreamingservice.data

import de.syntax_institut.filmestreamingservice.R
import de.syntax_institut.filmestreamingservice.data.model.MovieTitle

/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource {

    /**
     * Diese Funktion holt die Filmtitel aus der string Quelldatei
     * und liefert eine Liste aus Titlen zurück
     */
    fun loadTitles(): List<MovieTitle> {
        return listOf(
            MovieTitle(R.string.movie1),
            MovieTitle(R.string.movie2),
            MovieTitle(R.string.movie3),
            MovieTitle(R.string.movie4),
            MovieTitle(R.string.movie5),
            MovieTitle(R.string.movie6),
            MovieTitle(R.string.movie7),
            MovieTitle(R.string.movie8),
            MovieTitle(R.string.movie9),
            MovieTitle(R.string.movie10),
            MovieTitle(R.string.movie11),
            MovieTitle(R.string.movie12),
            MovieTitle(R.string.movie13),
            MovieTitle(R.string.movie14),
            MovieTitle(R.string.movie15),
            MovieTitle(R.string.movie16),
            MovieTitle(R.string.movie17),
            MovieTitle(R.string.movie18),
            MovieTitle(R.string.movie19),
            MovieTitle(R.string.movie20)
        )
    }
}
