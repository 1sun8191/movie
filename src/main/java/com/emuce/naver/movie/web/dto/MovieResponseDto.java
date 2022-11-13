package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MovieResponseDto {

    private Long id;
    private String title;
    private String contents;
    private LocalDateTime openDate;
    private String director;
//    private List<Review> reviews;
    private LocalDateTime makeDate;
    private String country;
    private Integer score;
    private String url;

    public MovieResponseDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.contents = movie.getContents();
        this.openDate = movie.getOpenDate();
        this.director = movie.getDirector();
//        this.reviews = movie.getReviews();
        this.makeDate = movie.getMakeDate();
        this.country = movie.getCountry();
        this.score = movie.getScore();
        this.url = movie.getUrl();
    }
}
