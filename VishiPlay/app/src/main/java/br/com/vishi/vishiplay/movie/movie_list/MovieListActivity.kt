package br.com.vishi.vishiplay.movie.movie_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vishi.vishiplay.R
import br.com.vishi.vishiplay.databinding.ActivityListMovieBinding
import br.com.vishi.vishiplay.movie.model.Movie

class MovieListActivity : AppCompatActivity() {

    lateinit var binding: ActivityListMovieBinding
    lateinit var moviesAdapter: MoviesAdapter

    private val viewModel: MoviesViewModel by lazy {
        ViewModelProviders.of(this).get(MoviesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_movie)

        val decoration = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        moviesAdapter = MoviesAdapter(){
            Log.d("MovieFragment",it.toString())
           // carregaFragment(MovieAddFragment.newInstance(it))
        }

        binding.layoutManager = GridLayoutManager(this,3)
        binding.dividerItemDecoration = decoration
        binding.adapter = moviesAdapter
        binding.viewModel = viewModel

        viewModel.data.observe(
            this, Observer<MutableCollection<Movie>> { response ->
                run {
                    moviesAdapter.setData(response)
                }
            }
        )
    }
}
