package com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp;

import android.app.Activity;

import com.example.andreivancea.daggerandrxmvpapp.app.network.DummyService;
import com.example.andreivancea.daggerandrxmvpapp.app.network.model.Post;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 4/20/2017.
 */

public class MainActivityModel {

    private final Activity activity;
    private final DummyService dummyService;

    public MainActivityModel(Activity activity, DummyService dummyService) {
        this.activity = activity;
        this.dummyService = dummyService;
    }

    public Observable<List<Post>> getAllPosts() {
        return dummyService.getPosts();
    }

    public Observable<Post> getChosenPost(int nr) {
        return dummyService.getChosenPost(nr);
    }
}
