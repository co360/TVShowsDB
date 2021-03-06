package com.ng.tvshowsdb.data.common.remote

import com.ng.tvshowsdb.data.common.remote.model.TvShowItems
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBService {

    @GET("tv/popular")
    fun getMostPopularTvShows(@Query("page") page: Int): Single<TvShowItems>

    @GET("tv/{tv_id}/similar")
    fun getSimilarTvShows(
        @Path("tv_id") id: Long,
        @Query("page") page: Int = 1
    ): Single<TvShowItems>
}