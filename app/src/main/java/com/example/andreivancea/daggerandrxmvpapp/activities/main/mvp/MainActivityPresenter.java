package com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp;

import com.example.andreivancea.daggerandrxmvpapp.app.network.model.Post;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrei on 4/20/2017.
 */

public class MainActivityPresenter {

    private final MainActivityView view;
    private final MainActivityModel model;
    private List<Disposable> disposables = new ArrayList<>();

    public MainActivityPresenter(MainActivityView view, MainActivityModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {
        disposables.add(observeGetAllButton());
        disposables.add(observeGetChosenButton());
    }


    public void onDestroy(){
        disposables.forEach(Disposable::dispose);
    }

    private Disposable observeGetChosenButton() {
        return view.observeGetChosenButton()
                .doOnNext(__ -> view.showLoading(true))
                .map(__ -> view.getPostNumberEdit())
                .observeOn(Schedulers.io())
                .switchMap(chosen -> model.getChosenPost(Integer.valueOf(chosen)))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(data -> view.setMessage(data.toString()));
    }

    private Disposable observeGetAllButton() {
        return view.observeGetAllButton()
                .doOnNext(__ -> view.showLoading(true))
                .observeOn(Schedulers.io())
                .switchMap(posts -> model.getAllPosts())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.showLoading(false))
                .subscribe(this::showAllPosts);
    }

    private void showAllPosts(List<Post> postList) {
        StringBuilder stringBuilder = new StringBuilder();
        postList.forEach(stringBuilder::append);
        view.setMessage(stringBuilder.toString());
    }
}
