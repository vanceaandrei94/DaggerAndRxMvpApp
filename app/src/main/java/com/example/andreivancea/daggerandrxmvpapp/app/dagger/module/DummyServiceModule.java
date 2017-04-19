package com.example.andreivancea.daggerandrxmvpapp.app.dagger.module;

import com.example.andreivancea.daggerandrxmvpapp.app.dagger.ApplicationScope;
import com.example.andreivancea.daggerandrxmvpapp.app.network.DummyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

@Module(includes = NetworkModule.class)
public class DummyServiceModule {

    @Provides
    @ApplicationScope
    public DummyService dummyService(Retrofit dummyRetrofit) {
        return dummyRetrofit.create(DummyService.class);
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }
}
