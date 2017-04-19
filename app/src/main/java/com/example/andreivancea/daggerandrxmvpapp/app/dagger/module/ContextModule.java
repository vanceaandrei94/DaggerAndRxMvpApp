package com.example.andreivancea.daggerandrxmvpapp.app.dagger.module;

import android.content.Context;

import com.example.andreivancea.daggerandrxmvpapp.app.dagger.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andrei.vancea on 4/19/2017.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    public Context context() {
        return context;
    }
}
