package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.Review;
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

    @Builder
    public ReviewSaveDto(Long movieId, String reviewContents, Integer score) {
        this.movieId = movieId;
        this.reviewContents = reviewContents;
        this.score = score;
//        this.author = author;
    }

    public Review toEntity() {
        return Review.builder()
                .movieId(movieId)
                .reviewContents(reviewContents)
                .score(score)
//                .author(author)
                .build();
    }

    @Override
    public String toString() {
        return "ReviewSaveDto{" +
                "movieId='" + movieId + '\'' +
                ", reviewContents='" + reviewContents + '\'' +
                ", score=" + score +
                '}';
    }
}
