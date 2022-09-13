package com.emuce.naver.movie.web;

import com.emuce.naver.movie.service.ReviewService;
import com.emuce.naver.movie.web.dto.ReviewSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("api/movie/review")
    public Long registerReview(@RequestBody ReviewSaveDto reviewSaveDto) {
        return reviewService.save(reviewSaveDto);
    }

    @PutMapping("api/movie/review/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewSaveDto reviewSaveDto) {
        return reviewService.update(id, reviewSaveDto);
    }

    @DeleteMapping("api/movie/review/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }



}
