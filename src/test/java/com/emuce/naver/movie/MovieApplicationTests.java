package com.emuce.naver.movie;

import com.emuce.naver.movie.domain.Movie;
import com.emuce.naver.movie.domain.MovieRepository;
import com.emuce.naver.movie.service.MovieService;
import com.emuce.naver.movie.web.dto.MovieResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MovieApplicationTests {

	@Autowired
	MovieService movieService;

	@Autowired
	MovieRepository movieRepository;

	@Test
	@Transactional
	public void 불러오기() {
		String title = "test";
		String contents = "test";
//		private LocalDateTime openDate;
		String director = "test";
//		private List<Review> reviews;
//		private LocalDateTime makeDate;
		String country = "test";

		movieRepository.save(Movie.builder()
				.title(title)
				.contents(contents)
				.director(director)
				.country(country)
				.openDate(LocalDateTime.now())
				.build());

		List<Movie> movieList = movieRepository.findAll();
//		List<Movie> movie = movieService.findAllMovieDesc();
		System.out.println("movie = " + movieList);
	}

}
