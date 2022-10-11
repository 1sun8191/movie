package com.emuce.naver.movie.web;

import com.emuce.naver.movie.config.auth.LoginUser;
import com.emuce.naver.movie.config.auth.dto.SessionUser;
import com.emuce.naver.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final MovieService movieService;

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








}
