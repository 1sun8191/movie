package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewSaveDto {

    private Long movieId;
    private String reviewContents;
//    private String author;
    private Integer score;
    private String userName;

    @Builder
    public ReviewSaveDto(Long movieId, String reviewContents, Integer score, String userName) {
        this.movieId = movieId;
        this.reviewContents = reviewContents;
        this.score = score;
        this.userName = userName;
    }

    public Review toEntity() {
        return Review.builder()
                .movieId(movieId)
                .reviewContents(reviewContents)
                .score(score)
                .userName(userName)
                .build();
    }

    @Override
    public String toString() {
        return "ReviewSaveDto{" +
                "movieId='" + movieId + '\'' +
                ", reviewContents='" + reviewContents + '\'' +
                ", score=" + score +
                ", userName=" + userName +
                '}';
    }
}
