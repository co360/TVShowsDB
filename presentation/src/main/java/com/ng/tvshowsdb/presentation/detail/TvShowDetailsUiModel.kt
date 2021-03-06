package com.ng.tvshowsdb.presentation.detail

data class TvShowDetailsUiModel(
    val id: Long,
    val title: String,
    val description: String,
    val posterPath: String,
    val backdropPath: String,
    val firstAirDate: String,
    val rating: String
)