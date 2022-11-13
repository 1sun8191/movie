package com.emuce.naver.movie.domain.review;

import com.emuce.naver.movie.domain.BaseTimeEntity;
import com.emuce.naver.movie.domain.user.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reviewId")
    private Long reviewId;


    @Column
    private Long movieId;


    @Column
    private String title;


    @Column
    private String userName;

    @Column(nullable = false)
    private String reviewContents;

    @Column(nullable = false)
    private Integer score;



    @Builder
    public Review(Long movieId, String reviewContents, Integer score, String title, String userName) {
        this.movieId = movieId;
        this.title = title;
        this.reviewContents = reviewContents;
        this.score = score;
        this.userName = userName;
    }

    public void update(String reviewContents, Integer score) {
        this.reviewContents = reviewContents;
        this.score = score;
    }
}
