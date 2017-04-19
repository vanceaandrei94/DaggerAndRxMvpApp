package com.example.andreivancea.daggerandrxmvpapp.app.network;

import com.example.andreivancea.daggerandrxmvpapp.app.network.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

public interface DummyService {

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts/{nr}")
    Observable<Post> getChosenPost(@Path("nr") int nr);
}
