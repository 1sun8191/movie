package com.emuce.naver.movie.service;

import com.emuce.naver.movie.domain.Review;
import com.emuce.naver.movie.web.dto.MovieResponseDto;
import com.emuce.naver.movie.web.dto.ReviewSaveDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class MovieService {

    private ReviewRepository reviewRepository;
    private MovieRepository movieRepository;

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

    public List<MovieResponseDto> findAllDesc() {
        return movieRepository.findAllDesc.stream().map((Movie movie) -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }


}
