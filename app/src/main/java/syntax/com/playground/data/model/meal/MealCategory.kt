package syntax.com.playground.data.model.meal

import com.squareup.moshi.Json
import syntax.com.playground.helpers.PGConstant

data class MealCategory(
    @Json(name = "idCategory")
    val id: String,
    @Json(name = "strCategory")
    val name: String = PGConstant.DEBUG_MSG_ERR_LOADING_DATA.strValue,
    @Json(name = "strCategoryThumb")
    val image: String = PGConstant.DEBUG_MSG_ERR_LOADING_DATA.strValue,
    @Json(name = "strCategoryDescription")
    val description: String = PGConstant.DEBUG_MSG_ERR_LOADING_DATA.strValue,
)
