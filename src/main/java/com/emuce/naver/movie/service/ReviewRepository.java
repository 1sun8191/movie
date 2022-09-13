package com.emuce.naver.movie.service;

import com.emuce.naver.movie.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
