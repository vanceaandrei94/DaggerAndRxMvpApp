package com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger;

import com.example.andreivancea.daggerandrxmvpapp.activities.main.MainActivity;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp.MainActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MainActivityView view(){
        return new MainActivityView(mainActivity);
    }
}
