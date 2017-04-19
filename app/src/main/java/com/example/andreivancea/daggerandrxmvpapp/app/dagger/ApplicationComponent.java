package com.example.andreivancea.daggerandrxmvpapp.app.dagger;

import android.content.Context;

import com.example.andreivancea.daggerandrxmvpapp.app.dagger.module.DummyServiceModule;
import com.example.andreivancea.daggerandrxmvpapp.app.network.DummyService;

import dagger.Component;

/**
 * Created by andrei.vancea on 4/19/2017.
 */
@ApplicationScope
@Component(modules = {DummyServiceModule.class})
public interface ApplicationComponent {

    void injectApplication(Context context);

}
