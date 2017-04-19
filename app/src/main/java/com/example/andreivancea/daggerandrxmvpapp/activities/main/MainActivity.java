package com.example.andreivancea.daggerandrxmvpapp.activities.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andreivancea.daggerandrxmvpapp.R;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger.DaggerMainActivityComponent;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.dagger.MainActivityModule;
import com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp.MainActivityView;
import com.example.andreivancea.daggerandrxmvpapp.app.DaggerAndRxMvpApplication;
import com.example.andreivancea.daggerandrxmvpapp.app.dagger.ApplicationComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.builder()
                .applicationComponent(DaggerAndRxMvpApplication.get(this).component())
                .mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
        setContentView(view);

    }
}
