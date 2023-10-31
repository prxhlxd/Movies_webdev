package dev.prahlad.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> createReviews(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Reviews>(reviewsService.createReviews(payload.get("reviewBody"), payload.get("title")), HttpStatus.CREATED);
    }
}
