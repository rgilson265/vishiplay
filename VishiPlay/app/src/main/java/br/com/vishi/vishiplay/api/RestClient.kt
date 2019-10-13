package br.com.vishi.vishiplay.api


import br.com.vishi.vishiplay.movie.model.Movie
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.*


interface RestClient {


    @GET("filmes.json")
    fun movies(@Query("orderBy")orderBy:String,
               @Query("equalTo")equalTo:String): Observable<HashMap<String, Movie>>

    @POST("filmes.json")
    fun post(@Body movie: Movie): Observable<ResponseBody>

    @PUT("filmes/{id}.json")
    //fun put(@Body movie: HashMap<String, Movie>): Observable<HashMap<String, Movie>>
    fun put(@Path("id") id: String,@Body movie: Movie): Observable<HashMap<String, Movie>>

    @DELETE("filmes/{id}.json")
    fun delete(@Path("id") id: String): Observable<ResponseBody>

    object Factory {

        fun create(): RestClient {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://developers.themoviedb.org/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(RestClient::class.java)
        }
    }
}