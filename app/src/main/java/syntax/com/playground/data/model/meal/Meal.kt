package syntax.com.playground.data.model.meal

import com.squareup.moshi.Json
import syntax.com.playground.helpers.PGConstant

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
    val meal: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue,

    @Json(name= "strCategory")
    val category: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue,

    @Json(name= "strArea")
    val area: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue,

    @Json(name= "strMealThumb")
    val image: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue
)
