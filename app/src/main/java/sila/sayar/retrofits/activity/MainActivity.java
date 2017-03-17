package sila.sayar.retrofits.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import sila.sayar.retrofits.R;
import sila.sayar.retrofits.adapter.PostAdapter;
import sila.sayar.retrofits.model.Post;
import sila.sayar.retrofits.rest.ApiClient;
import sila.sayar.retrofits.rest.ApiInterface;
import sila.sayar.retrofits.model.PostResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.posts_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Post>> call = apiService.getResults();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                int statusCode = response.code();
                List<Post> posts = response.body();
                recyclerView.setAdapter(new PostAdapter(posts, R.layout.list_item_post, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }


        });
    }
}
