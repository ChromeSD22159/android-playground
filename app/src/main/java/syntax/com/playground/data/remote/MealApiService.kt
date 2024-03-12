package syntax.com.playground.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import syntax.com.playground.data.model.MealResult

/**
 * Um unseren API-Service zu nutzen, brauchen wir insgesamt sechs Dinge:
 *
 * 1. Dependencies für Moshi und Retrofit.
 * 2. Die Base-URL der API.
 * 3. Einen Moshi-Client um die Antworten direkt in Objekte zu verwandeln.
 * 4. Einen Retrofit-Client um die Kommunikation mit der API zu übernehmen.
 * 5. Ein Interface, das die verschiedenen Endpunkte der API anspricht.
 * 6. Das Retrofit-Objekt, das alle oberen Teile vereint.
 */


/**
 * 2.
 * Die Base-URL wird angelegt.
 */
const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

/**
 * 3.
 * Moshi Client wird im Builder Pattern geschrieben.
 * Wir fügen eine KotlinJsonFactory hinzu, die später die
 * Übersetzung von Json in Kotlin für uns übernimmt.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * 4.
 * Retrofit Client wird im Builder Pattern geschrieben.
 * Wir fügen Moshi hinzu und setzen die Base-Url.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * 5.
 * Das Interface beschreibt alle Funktionen, die die API später haben soll.
 */
interface MealApiService {
    /**
     * Der Endpunkt für ein Random Meal wird angegeben.
     */
    @GET("random.php")
    suspend fun getRandomMeal(): MealResult

    /**
     * Es wird eine Funktion angelegt, die einen Namen hat
     * und zeigt, was später zurückgegeben wird.
     */
}

/**
 * 6.
 * Das Retrofit-Objekt vereint alle Dinge,
 * die wir oben geschrieben haben in einem Api-Service.
 */
object MealApi {
    val retrofitservice: MealApiService by lazy { retrofit.create(MealApiService::class.java) }
}
