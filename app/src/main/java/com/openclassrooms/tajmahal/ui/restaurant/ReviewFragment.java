package com.openclassrooms.tajmahal.ui.restaurant;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.openclassrooms.tajmahal.databinding.FragmentReviewsBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReviewFragment extends Fragment {

    private FragmentReviewsBinding binding;
    private ReviewAdapter adapter;
    private List<Review> reviewList = new ArrayList<>();
    private ReviewViewModel reviewViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentReviewsBinding.inflate(inflater, container, false); // Binds the layout using view binding.
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI();
        setupViewModel();

        // Initialize adapter and set it to RecyclerView
        adapter = new ReviewAdapter(this.getContext(), reviewList);
        binding.reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.reviewsRecyclerView.setAdapter(adapter);

        // Observe changes in the ViewModel
        reviewViewModel.getReviews().observe(getViewLifecycleOwner(), this::updateUIWithReview);
    }

    private void updateUIWithReview(List<Review> reviews) {
        reviewList.clear();
        reviewList.addAll(reviews);
        adapter.notifyDataSetChanged();// Update the adapter with new reviews
    }

    private void setupUI() {
        Window window = requireActivity().getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    private void setupViewModel() {
        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);
    }
}
