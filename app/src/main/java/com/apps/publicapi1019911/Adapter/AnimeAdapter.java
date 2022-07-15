package com.apps.publicapi1019911.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.publicapi1019911.R;
import com.apps.publicapi1019911.model.AnimeModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyHolder> {

    List<AnimeModel> dbList;
    Context context;

    public AnimeAdapter(Context context, List<AnimeModel> dbList) {
        this.dbList = dbList;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimeAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        AnimeAdapter.MyHolder holder = new AnimeAdapter.MyHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeAdapter.MyHolder holder, int position) {
        AnimeModel animeModel = dbList.get(position);
        holder.anime_names.setText(animeModel.getAnime_name());

        Glide.with(context)
                .load(animeModel.getAnime_img())
                .placeholder(R.drawable.avatar)
                .error(R.drawable.avatar)
                .into(holder.anime_images);

    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView anime_names;
        ImageView anime_images;
        public MyHolder(View layout) {
            super(layout);
            anime_names =(TextView)layout.findViewById(R.id.activity_name);
            anime_images = (ImageView) layout.findViewById(R.id.activity_image);
        }
    }
}
