package com.shofiq.simpledagger2.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shofiq.simpledagger2.repositories.PopularTvRepository;
import com.shofiq.simpledagger2.responses.TvShowResponse;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TvShowsViewModel extends ViewModel {
    private static final String TAG = "TvShowsViewModel";
    private PopularTvRepository popularTvRepository;
    private CompositeDisposable disposable=new CompositeDisposable();
    private MutableLiveData<TvShowResponse> showResponseMutableLiveData=new MutableLiveData<>();

    @Inject
    public TvShowsViewModel(PopularTvRepository popularTvRepository){
        this.popularTvRepository=popularTvRepository;
    }
    @Inject
    public LiveData<TvShowResponse> getShowResponseLiveData(){
        return showResponseMutableLiveData;
    }
    public void loadData(int page){
        disposable.add(popularTvRepository.getTvShows(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<TvShowResponse>(){

                    @Override
                    public void onSuccess(TvShowResponse value) {
                        showResponseMutableLiveData.setValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getLocalizedMessage() );
                    }
                })
        );
    }
}
