package by.alena.diplomproject.RemoteModel


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

val KEY = "123456789"            // ключ платный
val HOST = "the-cocktail-db.p.rapidapi.com"


val BASE_URL = "https://the-cocktail-db.p.rapidapi.com/"
interface ApiService {
    @GET("popular.php")
    suspend fun getCoctails(
        @Header("x-rapidapi-key") key:String,
        @Header("x-rapidapi-host")  host:String
    ): MyCoctails


    companion object Factory {
        fun create(): ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}