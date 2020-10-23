package com.shofiq.simpledagger2.remote;


import com.shofiq.simpledagger2.responses.TvShowResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("most-popular")
    Single<TvShowResponse> getPopularTvShows(@Query("page") int page);
}
