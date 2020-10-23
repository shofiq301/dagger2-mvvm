package com.shofiq.simpledagger2.di.components;

import com.shofiq.simpledagger2.di.modules.ContextModule;
import com.shofiq.simpledagger2.di.modules.NetworkModule;
import com.shofiq.simpledagger2.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
