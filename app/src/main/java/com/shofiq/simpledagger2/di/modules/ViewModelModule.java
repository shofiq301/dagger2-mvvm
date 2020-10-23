package com.shofiq.simpledagger2.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.shofiq.simpledagger2.di.ViewModelKey;
import com.shofiq.simpledagger2.viewmodels.TvShowsViewModel;
import com.shofiq.simpledagger2.viewmodels.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TvShowsViewModel.class)
    abstract ViewModel bindViewModel(TvShowsViewModel tvShowsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);

}
