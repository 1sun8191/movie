package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewSaveDto {

    private String reviewContents;
    private Integer score;

    @Builder
    public ReviewSaveDto(String reviewContents, Integer score) {
        this.reviewContents = reviewContents;
        this.score = score;
    }

    public Review toEntity() {
        return Review.builder()
                .reviewContents(reviewContents)
                .score(score)
                .build();
    }
}
