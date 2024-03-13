package syntax.com.playground.ui.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import syntax.com.playground.data.repo.MealRepository
import syntax.com.playground.data.remote.MealApi

class MealViewModel: ViewModel() {

    /**
     * Repository wird mit Hilfe des MealApi Objektes erstellt.
     */
    private val repository = MealRepository(MealApi)

    /**
     * Referenz auf die LiveData aus dem Repository.
     */
    val randomMeal = repository.randomMeal

    val allMealCategories = repository.mealCategories

    val mealsByCategory = repository.mealsByCat

    init {
        laodRandomMeal()
        loadAllMealCategories()
    }

    /**
     * Funktion die Laden der Daten im Repository in einer Coroutine startet.
     */
    fun laodRandomMeal() {
        viewModelScope.launch {
          repository.getRandomMeal()
        }
    }

    fun loadAllMealCategories() {
        viewModelScope.launch {
            repository.getAllMealCategories()
        }
    }

    fun loadMealsByCategory(category: String) {
        viewModelScope.launch {
            repository.getMealsByCat(category)
        }
    }
}