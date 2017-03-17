package sila.sayar.retrofits.rest;

/**
 * Created by zisan on 16.03.2017.
 */

import java.util.List;

import sila.sayar.retrofits.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("posts")
    Call<List<Post>> getResults();



}
