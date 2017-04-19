package com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger;

import com.example.andreivancea.daggerandrxmvpapp.activities.main.MainActivity;
import com.example.andreivancea.daggerandrxmvpapp.app.dagger.ApplicationComponent;

import dagger.Component;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
