package com.emuce.naver.movie.domain;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Review extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "movieId")
    private Movie movie;
//    private Long movieId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;
//    private Long memberId;

    @Column(nullable = false)
    private String reviewContents;

    @Column(nullable = false)
    private Integer score;

    @Builder
    public Review(String reviewContents, Integer score) {
        this.reviewContents = reviewContents;
        this.score = score;
    }

    public void update(String reviewContents, Integer score) {
        this.reviewContents = reviewContents;
        this.score = score;
    }
}
