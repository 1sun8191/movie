package com.emuce.naver.movie.web;

import com.emuce.naver.movie.config.auth.LoginUser;
import com.emuce.naver.movie.config.auth.dto.SessionUser;
import com.emuce.naver.movie.domain.movie.Movie;
import com.emuce.naver.movie.domain.review.Review;
import com.emuce.naver.movie.service.MovieService;
import com.emuce.naver.movie.service.ReviewService;
import com.emuce.naver.movie.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/")
//    public String index(Model model, @LoginUser SessionUser user) {
//        model.addAttribute("posts", movieService.findAllMovieDesc());
//        if(user != null) {
//            model.addAttribute("userName", user.getName());
//        }
    public String index(Model model) {
        model.addAttribute("movies", movieService.findAllMovieDesc());
        return "index";
    }

    @GetMapping("/movie/future")
    public String postsFuture(Model model, @LoginUser SessionUser user) {
        model.addAttribute("movies", movieService.findMovieFutureDesc());
//        return "posts-future";
        return "index";
    }

    @GetMapping("/movie/write")
    public String postsWrite(Model model) {
        model.addAttribute("movies", movieService.findMovieFutureDesc());
        return "posts-write";
//        return "index";
    }


    @GetMapping("/movie/score")
    public String postsScore(Model model) {
        model.addAttribute("movies", movieService.findMovieScoreDesc());
//        return "posts-score";
        return "index";
    }

    @GetMapping("/movie/reviewEnter/{id}")
    public String reviewSave(Model model, @PathVariable Long id) {
        Movie movieResponseDto = movieService.findMovieById(id);
        model.addAttribute("reviewEnter", movieResponseDto);
        model.addAttribute("title", movieResponseDto.getTitle());
        System.out.println("reviewEnter = " + model.getAttribute("reviewEnter"));
        System.out.println("title = " + model.getAttribute("title"));
        return "movie-review";
    }

    @GetMapping("/movie/reviewUpdate/{reviewId}")
    public ModelAndView reviewUpdate(Model model, @PathVariable Long reviewId) {
        Review reviewSaveDto = reviewService.findReviewById(reviewId);
        System.out.println("reviewSaveDto = " + reviewSaveDto.toString());
        model.addAttribute("reviewUpdate", reviewSaveDto);
        System.out.println("reviewUpdate = " + model.getAttribute("reviewUpdate").toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movie-review-update");
        modelAndView.addObject("reviewUpdate", reviewSaveDto);
        return modelAndView;
    }

    @GetMapping("movie/review/{id}")
    public String findReview(Model model, @PathVariable Long id) {
        List<ReviewResponseDto> reviewResponseDto = reviewService.findAllReviewDesc(id);
        model.addAttribute("reviews",reviewResponseDto);
        System.out.println("reviews = " + model.getAttribute("reviews"));
        return "review";
    }






}
