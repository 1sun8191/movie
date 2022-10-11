package com.emuce.naver.movie.service;

import com.emuce.naver.movie.domain.Movie;
import com.emuce.naver.movie.domain.Review;
import com.emuce.naver.movie.domain.ReviewRepository;
import com.emuce.naver.movie.web.dto.ReviewResponseDto;
import com.emuce.naver.movie.web.dto.ReviewSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Long save(ReviewSaveDto reviewSaveDto) {
        return reviewRepository.save(reviewSaveDto.toEntity()).getReviewId();
    }

    @Transactional
    public Long update(Long id, ReviewSaveDto reviewSaveDto) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다. id = " + id));
        review.update(reviewSaveDto.getReviewContents(), reviewSaveDto.getScore());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        reviewRepository.delete(review);
    }

    public List<ReviewResponseDto> findAllReviewDesc(Long movieId) {
        String reviewContents = "reviewContents";
        Integer score = 4;
        System.out.println("1111111111111111111111111111");
        reviewRepository.save(Review.builder()
                .reviewContents(reviewContents)
                .score(score)
                .build());
        System.out.println("2222222222222222222222222222");

        return reviewRepository.findById(movieId).stream().map((Review review) -> new ReviewResponseDto(review)).collect(Collectors.toList());
    }


}
