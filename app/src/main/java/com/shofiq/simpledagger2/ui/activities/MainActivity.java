package com.shofiq.simpledagger2.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shofiq.simpledagger2.R;
import com.shofiq.simpledagger2.adapters.RecyclerTvShowAdapter;
import com.shofiq.simpledagger2.application.AppController;
import com.shofiq.simpledagger2.databinding.ActivityMainBinding;
import com.shofiq.simpledagger2.listeners.TvShowListener;
import com.shofiq.simpledagger2.models.TvShow;
import com.shofiq.simpledagger2.viewmodels.TvShowsViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements TvShowListener {

    private ActivityMainBinding binding;

    @Inject
    ViewModelProvider.Factory factory;
    private TvShowsViewModel tvShowsViewModel;

    private List<TvShow> tvShows;
    private RecyclerTvShowAdapter tvShowAdapter;
    private int currentPage=1;
    private int totalPages=1;
    private boolean isLoading=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((AppController)getApplication()).getAppComponent().inject(this);
        setUpViews();
        tvShowsViewModel= new ViewModelProvider(this, factory).get(TvShowsViewModel.class);
        toggleLoading();
        tvShowsViewModel.loadData(currentPage);
        getMostPopularTvShows();


    }
    private void setUpViews() {
        binding.recyclerTvList.setHasFixedSize(true);
        tvShows = new ArrayList<>();
        tvShowAdapter = new RecyclerTvShowAdapter(tvShows, this);
        tvShowAdapter.setHasStableIds(true);
        binding.recyclerTvList.setAdapter(tvShowAdapter);

        binding.recyclerTvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!binding.recyclerTvList.canScrollVertically(1)){
                    if (currentPage<=totalPages && !isLoading){
                        currentPage+=1;
                        tvShowsViewModel.loadData(currentPage);
                        toggleLoading();

                    }
                }
            }
        });
    }

    private void getMostPopularTvShows() {
        tvShowsViewModel.getShowResponseLiveData().observe(this, tvShowResponse -> {
            toggleLoading();
            if (tvShowResponse!=null){
                isLoading=false;
                totalPages=tvShowResponse.getPages();
                if (tvShowResponse.getTvShows()!=null){
                    int oldCount = tvShows.size();
                    tvShows.addAll(tvShowResponse.getTvShows());
                    tvShowAdapter.notifyItemRangeInserted(oldCount,tvShows.size());
                }
            }
        });
    }


    private void toggleLoading(){
        if (currentPage==1){
            binding.setIsLoading(binding.getIsLoading() == null || !binding.getIsLoading());
        }else {
            isLoading=true;
            binding.setIsLoadingMore(binding.getIsLoadingMore() == null || !binding.getIsLoadingMore());
        }
    }

    @Override
    public void onTvShowClicked(TvShow tvShow) {
        Toast.makeText(this, ""+tvShow.getName(), Toast.LENGTH_SHORT).show();
    }

}