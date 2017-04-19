package com.example.andreivancea.daggerandrxmvpapp.activities.main.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.andreivancea.daggerandrxmvpapp.R;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

@SuppressLint("ViewConstructor")
public class MainActivityView extends FrameLayout {

    @BindView(R.id.edit_posts_number)
    EditText postNumberEditText;

    @BindView(R.id.btn_get_all_posts_btn)
    Button getAllPostsBtn;

    @BindView(R.id.btn_get_selected_post_btn)
    Button getChosenOneBtn;

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());

    public MainActivityView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.activity_main, this);
        progressDialog.setMessage("Getting Posts");
        ButterKnife.bind(this);
    }

    public void setMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public Observable<Object> observeGetAllButton() {
        return RxView.clicks(getAllPostsBtn);
    }

    public Observable<Object> observeGetChosenButton() {
        return RxView.clicks(getChosenOneBtn);
    }

    public String getPostNumberEdit() {
        return postNumberEditText.getText().toString();
    }

    public void showLoading(boolean loading) {
        if (loading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

}
