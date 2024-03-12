package syntax.com.playground.ui.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import syntax.com.playground.data.Repository
import syntax.com.playground.data.remote.MealApi

class RandomMealViewModel: ViewModel() {

    /**
     * Repository wird mit Hilfe des MealApi Objektes erstellt.
     */
    private val repository = Repository(MealApi)

    val randomMeal = repository.randomMeal

    /**
     * Referenz auf die LiveData aus dem Repository.
     */

    /**
     * Funktion die Laden der Daten im Repository in einer Coroutine startet.
     */

    init {
        laodRandomMeal()
    }

    fun laodRandomMeal() {
        viewModelScope.launch {
          repository.getRandomMeal()
        }
    }
}