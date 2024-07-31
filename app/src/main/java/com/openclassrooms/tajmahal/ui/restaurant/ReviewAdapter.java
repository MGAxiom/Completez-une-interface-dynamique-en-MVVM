package com.openclassrooms.tajmahal.ui.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<Review> reviews;
    private LayoutInflater inflater;

    ReviewAdapter(Context context, List<Review> reviews) {
        this.reviews = reviews;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.review_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Review review = reviews.get(position);
        holder.usernameView.setText(review.getUsername());
        holder.reviewView.setText(review.getComment());
        holder.ratingBar.setRating(review.getRate());
        Picasso.get().load(review.getPicture()).into(holder.profilePictureView);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView usernameView;
        TextView reviewView;
        ImageView profilePictureView;
        RatingBar ratingBar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameView = itemView.findViewById(R.id.username);
            reviewView = itemView.findViewById(R.id.listProfileReview);
            profilePictureView = itemView.findViewById(R.id.listProfileImage);
            ratingBar = itemView.findViewById(R.id.profileRatingBar);
        }
    }
}
