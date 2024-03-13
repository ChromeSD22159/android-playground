package syntax.com.playground.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import syntax.com.playground.data.model.meal.MealCategoryResult
import syntax.com.playground.data.model.meal.MealResult

/**
 * Um unseren API-Service zu nutzen, brauchen wir insgesamt sechs Dinge:
 *
 * @see 1. Dependencies für Moshi und Retrofit.
 * @see 2. Die Base-URL der API.
 * @see 3. Einen Moshi-Client um die Antworten direkt in Objekte zu verwandeln.
 * @see 4. Einen Retrofit-Client um die Kommunikation mit der API zu übernehmen.
 * @see 5. Ein Interface, das die verschiedenen Endpunkte der API anspricht.
 * @see 6. Das Retrofit-Objekt, das alle oberen Teile vereint.
 */


/**
 * @see 2.
 * Die Base-URL wird angelegt.
 */
const val BASE_URL = "https://www.themealdb.com/api/json/v2/9973533/"

/**
 * @see 3. Moshi Client
 * Moshi Client wird im Builder Pattern geschrieben.
 * Wir fügen eine KotlinJsonFactory hinzu, die später die
 * Übersetzung von Json in Kotlin für uns übernimmt.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * @see 4. Retrofit Client
 * Retrofit Client wird im Builder Pattern geschrieben.
 * Wir fügen Moshi hinzu und setzen die Base-Url.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * @see 5.Interface - APIService
 * Das Interface beschreibt alle Funktionen, die die API später haben soll.
 */
interface MealApiService {
    /**
     * Endpunkt für ein Random Meal wird angegeben.
     */
    @GET("random.php")
    suspend fun getRandomMeal(): MealResult

    /**
     * Endpunkt für alle Meal Kategorien.
     */
    @GET("categories.php")
    suspend fun getAllMealCategorires(): MealCategoryResult

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealResult
}

/**
 * @see 6. Retrofit-Objekt
 * Das Retrofit-Objekt vereint alle Dinge,
 * die wir oben geschrieben haben in einem Api-Service.
 */
object MealApi {
    val retrofitService: MealApiService by lazy { retrofit.create(MealApiService::class.java) }
}
