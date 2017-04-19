package com.example.andreivancea.daggerandrxmvpapp.app;

import android.app.Activity;
import android.app.Application;

import com.example.andreivancea.daggerandrxmvpapp.app.dagger.ApplicationComponent;
import com.example.andreivancea.daggerandrxmvpapp.app.dagger.DaggerApplicationComponent;
import com.example.andreivancea.daggerandrxmvpapp.app.dagger.module.ContextModule;
import com.example.andreivancea.daggerandrxmvpapp.app.network.DummyService;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

public class DaggerAndRxMvpApplication extends Application {

    private ApplicationComponent component;

    public static DaggerAndRxMvpApplication get(Activity activity) {
        return (DaggerAndRxMvpApplication) activity.getApplication();
    }

    @Inject
    DummyService dummyService;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

    }

    public ApplicationComponent component() {
        return component;
    }

}
