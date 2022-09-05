package com.emuce.naver.movie.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Movie extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private LocalDateTime openDate;

    @Column(nullable = false)
    private String director;

    @OneToMany(mappedBy = "reviewId")
    private List<Review> reviews;

    @Column
    private LocalDateTime makeDate;

    @Column(nullable = false)
    private String country;



}
