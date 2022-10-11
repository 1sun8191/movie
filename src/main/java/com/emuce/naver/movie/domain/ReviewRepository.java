package com.emuce.naver.movie.domain;

import com.emuce.naver.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT p FROM Review p ORDER BY p.reviewId DESC")
    public List<Review> findAllReviewDesc();
}
