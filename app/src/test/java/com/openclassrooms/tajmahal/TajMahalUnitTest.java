package com.openclassrooms.tajmahal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.data.service.RestaurantApi;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TajMahalUnitTest {

//    @Rule
//    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RestaurantFakeApi restaurantFakeApi;
    private RestaurantRepository restaurantRepository;

    @Before
    public void setUp() {
        restaurantFakeApi = new RestaurantFakeApi();
    }

    //Test to check if creating a new review works correctly
    @Test
    public void testAddReviewAndCheckSize() {
        Review newReview = new Review("John Doe", "https://example.com/johndoe.jpg", "Amazing food!", 5);

        //Add the review to the list using the setReviews method
        restaurantFakeApi.setReviews(newReview);

        // Verify if the review is correctly added in the list and check its size
        List<Review> reviews = restaurantFakeApi.getReviews();
        assertEquals(6, reviews.size()); // Assuming there were initially 5 reviews
        assertEquals(newReview, reviews.get(0)); // New review should be at the beginning of the list
    }

    //Test to check if creating a new review adds it at the beginning of the list
    @Test
    public void testAddReviewAndCheckData() {
        Review newReview = new Review("John Doe", "https://example.com/johndoe.jpg", "Gorgeous cuisine, can only recommend it!", 5);

        restaurantFakeApi.setReviews(newReview);

        // Verify if the review is at the correct index in the list
        List<Review> reviews = restaurantFakeApi.getReviews();
        assertEquals(reviews.get(0), newReview);;
    }

    //Test to check if creating a new review adds it at the beginning of the list
    @Test
    public void testCheckIfIncompleteReviewsAreNotAdded() {
        Review newReview = new Review("", "", "", 0);

        restaurantFakeApi.setReviews(newReview);

        // Verify if the review is at the correct index in the list
        List<Review> reviews = restaurantFakeApi.getReviews();
        assertNotEquals(6, reviews.size()); // Assuming there were initially 5 reviews
    }
}