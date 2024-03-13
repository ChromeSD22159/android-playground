package syntax.com.playground.data.model.meal

import com.squareup.moshi.Json
import syntax.com.playground.helpers.PGConstant

data class MealCategory(
    @Json(name = "idCategory")
    val id: Int = 0,
    @Json(name = "strCategory")
    val name: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue,
    @Json(name = "strCategoryThumb")
    val image: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue,
    @Json(name = "strCategoryDescription")
    val description: String = PGConstant.INTERROBANG_PUNCTION_MARK.strValue
)
