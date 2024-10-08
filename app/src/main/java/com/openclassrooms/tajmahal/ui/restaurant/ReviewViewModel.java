package com.openclassrooms.tajmahal.ui.restaurant;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ReviewViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    /**
     * Constructor that Hilt will use to create an instance of MainViewModel.
     *
     * @param restaurantRepository The repository which will provide restaurant data.
     */
    @Inject
    public ReviewViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Fetches the details of the Taj Mahal restaurant.
     *
     * @return LiveData object containing the details of the Taj Mahal restaurant.
     */
    public LiveData<List<Review>> getReviews() {
        return restaurantRepository.getReviews();
    }

    public void setReviews(Review reviews) {
        restaurantRepository.setReviews(reviews);
    }

    public String getProfileImageUrl() {
        return "https://xsgames.co/randomusers/assets/avatars/female/70.jpg";
    }
}