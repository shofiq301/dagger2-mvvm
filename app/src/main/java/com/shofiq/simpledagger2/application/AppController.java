package com.shofiq.simpledagger2.application;

import android.app.Application;

import com.shofiq.simpledagger2.di.components.AppComponent;
import com.shofiq.simpledagger2.di.components.DaggerAppComponent;

public class AppController extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
