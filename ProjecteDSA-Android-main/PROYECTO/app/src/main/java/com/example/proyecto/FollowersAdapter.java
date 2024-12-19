package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.models.GitHubFollower;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowerViewHolder> {
    private List<GitHubFollower> followers;

    public FollowersAdapter(List<GitHubFollower> followers) {
        this.followers = followers;
    }

    @NonNull
    @Override
    public FollowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower, parent, false);
        return new FollowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowerViewHolder holder, int position) {
        GitHubFollower follower = followers.get(position);
        holder.textViewUsername.setText(follower.getLogin());
        Picasso.get().load(follower.getAvatar_url()).into(holder.imageViewAvatar);
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }
    static class FollowerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUsername;
        ImageView imageViewAvatar;

        public FollowerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
        }
    }
}
