package sila.sayar.retrofits.adapter;

/**
 * Created by zisan on 16.03.2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import sila.sayar.retrofits.R;
import sila.sayar.retrofits.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts;
    private int rowLayout;
    private Context context;


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        LinearLayout postsLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public PostViewHolder(View v) {
            super(v);
            postsLayout = (LinearLayout) v.findViewById(R.id.posts_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public PostAdapter(List<Post> movies, int rowLayout, Context context) {
        this.posts = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PostViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PostViewHolder holder, final int position) {
        holder.movieTitle.setText(posts.get(position).getTitle());
        holder.data.setText("25/11/1988");
        holder.movieDescription.setText(posts.get(position).getBody());
        holder.rating.setText("8.1");
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
