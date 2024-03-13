package syntax.com.playground.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import syntax.com.playground.data.model.meal.Meal
import syntax.com.playground.data.model.meal.MealCategory
import syntax.com.playground.data.remote.MealApi

const val TAG = "MealRepository"

class MealRepository(private val apiService: MealApi) {

    /**
     * Live-Data um ein zufälliges Meal zu halten.
     */
    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    private var _mealCategories = MutableLiveData<List<MealCategory>>()
    val mealCategories: LiveData<List<MealCategory>>
        get() = _mealCategories

    private var _mealsByCat = MutableLiveData<List<Meal>>()
    val mealsByCat: LiveData<List<Meal>>
        get() = _mealsByCat

    /**
     * Suspend Funktion um die Funktion des Api Services auszuführen.
     * Sobald ein Ergebnis da ist wird es in die LiveData geschrieben.
     */
    suspend fun getRandomMeal() {
        try {
            val result = apiService.retrofitService.getRandomMeal()
            _randomMeal.postValue(result.mealList.first())
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from API getRandomMeal(): $e")
        }
    }

    suspend fun getAllMealCategories() {
        try {
            val result = apiService.retrofitService.getAllMealCategorires()
            _mealCategories.postValue(result.categories)
        } catch(e:Exception) {
            Log.e(TAG, "Error loading Data from API getAllMealCategories(): $e")
        }
    }

    suspend fun getMealsByCat(category: String) {
        val result = apiService.retrofitService.getMealsByCategory(category)
        _mealsByCat.postValue(result.mealList)

        delay(1000L)
    }
}