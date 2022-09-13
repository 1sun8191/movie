package com.emuce.naver.movie.web.dto;

import com.emuce.naver.movie.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class MovieResponseDto {

    private Long movieId;
    private String title;
    private String contents;
    private LocalDateTime openDate;
    private String director;
    private List<Review> reviews;
    private LocalDateTime makeDate;
    private String country;

}
