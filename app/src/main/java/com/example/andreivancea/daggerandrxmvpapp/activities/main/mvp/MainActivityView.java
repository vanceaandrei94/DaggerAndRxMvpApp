package com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.andreivancea.daggerandrxmvpapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

public class MainActivityView extends LinearLayout {

    @BindView(R.id.posts_number)
    EditText postNumberEditText;

    @BindView(R.id.get_all_posts_btn)
    Button getAllPostsBtn;

    @BindView(R.id.get_selected_post_btn)
    Button getChosenOneBtn;

    public MainActivityView(Activity activity) {
        super(activity);

        inflate(activity, R.layout.activity_main, this);
        ButterKnife.bind(this);
    }

}
