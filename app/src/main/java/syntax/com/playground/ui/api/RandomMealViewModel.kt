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

    /**
     * Referenz auf die LiveData aus dem Repository.
     */
    val randomMeal = repository.randomMeal
    init {
        laodRandomMeal()
    }

    /**
     * Funktion die Laden der Daten im Repository in einer Coroutine startet.
     */
    fun laodRandomMeal() {
        viewModelScope.launch {
          repository.getRandomMeal()
        }
    }
}