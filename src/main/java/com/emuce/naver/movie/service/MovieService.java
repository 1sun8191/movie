package com.emuce.naver.movie.service;

import com.emuce.naver.movie.domain.Movie;
import com.emuce.naver.movie.domain.MovieRepository;
import com.emuce.naver.movie.web.dto.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

//    @Transactional(readOnly = true)         //조회 기능만 남겨두어 조회 속도가 개선
    public List<MovieResponseDto> findAllMovieDesc() {

        Random random = new Random();

        String title = "title";
        String contents = "contents";
//		private LocalDateTime openDate;
        String director = "director";
//		private List<Review> reviews;
//		private LocalDateTime makeDate;
        String country = "country";
        Integer score = random.nextInt(4)+1;
        System.out.println("1111111111111111111111111111");
        log.info("<<<<<<<<<<<<<<시작");
        movieRepository.save(Movie.builder()
                .title(title)
                .contents(contents)
                .director(director)
                .country(country)
                .openDate(LocalDateTime.now())
                .makeDate(LocalDateTime.now())
                .score(score)
                .build());
        System.out.println("2222222222222222222222222222");
        System.out.println("movieRepository = " + movieRepository.findAll());
//        return  movieRepository.findAll();

        return movieRepository.findAllMovieDesc().stream().map((Movie movie) -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }

    public List<MovieResponseDto> findMovieFutureDesc() {
        return movieRepository.findMovieFutureDesc().stream().map((Movie movie) -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }

    public List<MovieResponseDto> findMovieScoreDesc() {
//        return  movieRepository.findAll();
        return movieRepository.findMovieScoreDesc().stream().map((Movie movie) -> new MovieResponseDto(movie)).collect(Collectors.toList());
    }

}
