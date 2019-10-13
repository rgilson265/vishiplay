package br.com.vishi.vishiplay.movie.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Movie(
    var id: String? = null,
    var type: String? = "",
    var website: String? = "",
    var title: String? = "",
    var released: String? = "",
    var runtime: String? = "",
    var genre: String? = "",
    var plot: String? = "",
    var awards: String? = "",
    var poster: String? = ""
) : Parcelable