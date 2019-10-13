package br.com.vishi.vishiplay.movie.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.vishi.vishiplay.R
import br.com.vishi.vishiplay.databinding.ItemListMovieBinding
import br.com.vishi.vishiplay.movie.model.Movie


class MoviesAdapter(val onItemClickListener:(movie: Movie)->Unit) : RecyclerView.Adapter<MovieViewHolder>() {

    private var list: MutableCollection<Movie> = mutableListOf()
    private lateinit var binding : ItemListMovieBinding

    fun setData(list: MutableCollection<Movie>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list_movie, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = list.elementAt(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
           onItemClickListener(movie)
        }
    }

    override fun getItemCount(): Int = list.size
}