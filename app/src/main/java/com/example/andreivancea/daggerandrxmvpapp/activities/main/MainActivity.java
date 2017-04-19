package com.example.andreivancea.daggerandrxmvpapp.activities.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger.DaggerMainActivityComponent;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger.MainActivityModule;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp.MainActivityPresenter;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp.MainActivityView;
import com.example.andreivancea.daggerandrxmvpapp.app.DaggerAndRxMvpApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityView view;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.builder()
                .applicationComponent(DaggerAndRxMvpApplication.get(this).component())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
        setContentView(view);

        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
