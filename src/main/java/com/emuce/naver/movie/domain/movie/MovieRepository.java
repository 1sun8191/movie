package com.emuce.naver.movie.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT p FROM Movie p ORDER BY p.id DESC")
    List<Movie> findAllMovieDesc();

    @Query("SELECT p FROM Movie p ORDER BY p.openDate")
    List<Movie> findMovieFutureDesc();

    @Query("SELECT p FROM Movie p ORDER BY p.score DESC")
    List<Movie> findMovieScoreDesc();
}
