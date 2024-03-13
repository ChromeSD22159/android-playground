package syntax.com.playground.data.model.meal

import com.squareup.moshi.Json
import syntax.com.playground.helpers.PGConstant

data class MealCategory(
    @Json(name = "idCategory")
    val id: String,
    @Json(name = "strCategory")
    val name: String = PGConstant.ERROR_STR_DEBUG_MESSAGE.strValue,
    @Json(name = "strCategoryThumb")
    val image: String = PGConstant.ERROR_STR_DEBUG_MESSAGE.strValue,
    @Json(name = "strCategoryDescription")
    val description: String = PGConstant.ERROR_STR_DEBUG_MESSAGE.strValue,
)
