package com.emuce.naver.movie.domain;

import lombok.Builder;
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

    @Column(nullable = false)
    private Integer score;

    @Builder
    public Movie(String title, String contents, LocalDateTime openDate, String director, LocalDateTime makeDate, String country, Integer score) {
        this.title = title;
        this.contents = contents;
        this.openDate = openDate;
        this.director = director;
        this.makeDate = makeDate;
        this.country = country;
        this.score = score;
    }

    public void update(String title, String contents, LocalDateTime openDate, String director, LocalDateTime makeDate, String country, Integer score) {
        this.title = title;
        this.contents = contents;
        this.openDate = openDate;
        this.director = director;
        this.makeDate = makeDate;
        this.country = country;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", openDate=" + openDate +
                ", director='" + director + '\'' +
                ", reviews=" + reviews +
                ", makeDate=" + makeDate +
                ", country='" + country + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
