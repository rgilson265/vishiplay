package br.com.vishi.vishiplay.movie.movie_list

import androidx.recyclerview.widget.RecyclerView
import br.com.vishi.vishiplay.databinding.ItemListFilmeBinding
import br.com.vishi.vishiplay.movie.model.Movie


class MovieViewHolder(private val binding: ItemListFilmeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.model = movie
    }
}