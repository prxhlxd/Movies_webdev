package dev.prahlad.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews createReviews(String reviewBody, String title){
        Reviews reviews = reviewsRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("title").is(title))
                .apply(new Update().push("reviewIds").value(reviews))
                .first();
        return reviews;
    }
}
