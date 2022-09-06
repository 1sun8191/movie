package com.emuce.naver.movie.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/write")
    public String postsWrite() {
        return "posts-write";
    }

    @GetMapping("/posts/future")
    public String postsFuture() {
        return "posts-future";
    }

    @GetMapping("/posts/score")
    public String postsScore() {
        return "posts-score";
    }

    @GetMapping("/posts/review")
    public String postsSave() {
        return "posts-review";
    }






}
