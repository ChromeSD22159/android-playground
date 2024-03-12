package syntax.com.playground.data.model

import com.squareup.moshi.Json

/**
 * Klasse um ein Meal abzubilden.
 */
data class Meal(

    /**
     * Wir können Werte umbenennnen indem wir vorher über
     * die Json Annotation den Namen davon angeben.
     */
    val idMeal: Int,

    @Json(name= "strMeal")
    val meal: String,

    @Json(name= "strCategory")
    val category: String,

    @Json(name= "strArea")
    val area: String,

    @Json(name= "strMealThumb")
    val image: String
)
