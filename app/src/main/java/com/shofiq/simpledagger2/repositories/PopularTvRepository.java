package com.shofiq.simpledagger2.repositories;

import com.shofiq.simpledagger2.remote.ApiInterface;
import com.shofiq.simpledagger2.responses.TvShowResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class PopularTvRepository {
    private ApiInterface apiInterface;


    @Inject
    public PopularTvRepository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }
    public Single<TvShowResponse> getTvShows(int page){
        return apiInterface.getPopularTvShows(page);
    }

//    public LiveData<TvShowResponse> getPopularTvShows(int page){
//        MutableLiveData<TvShowResponse> data =new MutableLiveData<>();
//        ApiClient.getInstance().getApi().getPopularTvShows(page).enqueue(new Callback<TvShowResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<TvShowResponse> call, @NonNull Response<TvShowResponse> response) {
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TvShowResponse> call, @NonNull Throwable t) {
//
//            }
//        });
//        return data;
//    }
}
