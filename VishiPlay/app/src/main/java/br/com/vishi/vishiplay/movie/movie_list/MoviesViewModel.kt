package br.com.vishi.vishiplay.movie.movie_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.vishi.vishiplay.movie.model.Movie
import br.com.vishi.vishiplay.api.RestClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel : ViewModel() {

    lateinit var subscribe: Disposable
    private val client = RestClient.Factory.create()
    val data: MutableLiveData<MutableCollection<Movie>> = MutableLiveData()

    init {
        loadData()
    }

    fun loadData() {

        subscribe = client.movies("\"type\"","\"filme\"")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                System.out.println(response)
                Log.d("ERRO",response.toString())
                data.postValue(response.values)
            }, { error ->
                System.out.println(error.toString())
            })
    }

    override fun onCleared() {
        super.onCleared()
        subscribe.dispose()
    }
}