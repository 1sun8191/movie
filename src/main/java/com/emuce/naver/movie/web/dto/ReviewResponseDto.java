package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.user.Member;
import com.emuce.naver.movie.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseDto {

    private Long reviewId;
    private Long movieId;
    private String title;
    private Member member;
//    private Long movieId;
//    private Long memberId;
    private String reviewContents;
    private Integer score;
    private String userName;

    public ReviewResponseDto(Review review) {
        this.reviewId = review.getReviewId();
        this.movieId = review.getMovieId();
        this.title = review.getTitle();
//        this.memberId = review.getMemberId();
//        this.movieId = review.getMovie().getId();
        this.userName = review.getUserName();
        this.reviewContents = review.getReviewContents();
        this.score = review.getScore();
    }
}
