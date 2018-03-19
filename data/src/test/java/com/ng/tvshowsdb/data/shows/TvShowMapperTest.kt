package com.ng.tvshowsdb.data.shows

import com.ng.tvshowsdb.data.common.remote.model.TvShowItem
import com.ng.tvshowsdb.data.common.remote.model.TvShowItems
import com.ng.tvshowsdb.domain.model.TvShow
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

private const val PAGE = 1
private const val TOTAL_PAGES = 5

class TvShowMapperTest {

  private lateinit var mapper: TvShowMapper

  @Before
  fun setup() {
    mapper = TvShowMapper()
  }

  @Test
  fun `TvShowItem remote is mapped to TvShow entity`() {
    val result = mapper.map(
        TvShowItems(listOf(
            TvShowItem(1, "La casa de papel",
                "Money Heist", "poster", "backdrop",
                8.9, "2017"
            )
        ), PAGE, TOTAL_PAGES)
    )
    val tvShow = TvShow(1, "La casa de papel",
        "Money Heist", "poster", "backdrop",
        "2017", 8.9)
    assertTrue(result.currentPage == 1)
    assertTrue(result.totalPages == TOTAL_PAGES)
    assertTrue(result.shows.first() == tvShow)
  }

  @Test
  fun `TvShowItem remote with just id is mapped to TvShow entity with defaults`() {
    val result = mapper.map(
        TvShowItems(listOf(
            TvShowItem(1,
                null, null, null,
                null, null, null
            )
        ), PAGE, TOTAL_PAGES)
    )
    val tvShow = TvShow(1, "",
        "", "", "",
        "", 0.0)
    assertTrue(result.currentPage == 1)
    assertTrue(result.totalPages == TOTAL_PAGES)
    assertTrue(result.shows.first() == tvShow)
  }
}