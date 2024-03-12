package syntax.com.playground.data.model

import com.squareup.moshi.Json

/**
 * Klasse um eine Liste von Meals zu halten.
 */
data class MealResult(

    @Json(name= "meals")
    val mealList: List<Meal>
)
