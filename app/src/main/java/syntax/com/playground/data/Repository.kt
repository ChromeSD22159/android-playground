package syntax.com.playground.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import syntax.com.playground.data.model.Meal
import syntax.com.playground.data.remote.MealApi

class Repository(private val apiService: MealApi) {

    /**
     * Live-Data um ein zufälliges Meal zu halten.
     */
    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    /**
     * Suspend Funktion um die Funktion des Api Services auszuführen.
     * Sobald ein Ergebnis da ist wird es in die LiveData geschrieben.
     */
    suspend fun getRandomMeal() {
        val result = apiService.retrofitservice.getRandomMeal()
        _randomMeal.postValue(result.mealList.first())
    }
}