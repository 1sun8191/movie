package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.Member;
import com.emuce.naver.movie.domain.Movie;
import com.emuce.naver.movie.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewResponseDto {

    private Long reviewId;
    private Movie movie;
    private Member member;
//    private Long movieId;
//    private Long memberId;
    private String reviewContents;
    private Integer score;

    public ReviewResponseDto(Review review) {
        this.reviewId = review.getReviewId();
//        this.movieId = review.getMovieId();
//        this.memberId = review.getMemberId();
        this.movie = review.getMovie();
        this.member = review.getMember();
        this.reviewContents = review.getReviewContents();
        this.score = review.getScore();
    }
}
