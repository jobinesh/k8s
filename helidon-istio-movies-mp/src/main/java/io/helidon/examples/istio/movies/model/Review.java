package io.helidon.examples.istio.movies.model;

import java.util.Date;

public class Review {
    private long id;
    private long userId;
    private long movieId;
    private String review;
    private Date reviewedDate;


    public Review() {
    }

    public Review(long id, long userId, long movieId, String review, Date reviewedDate) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.review = review;
        this.reviewedDate = reviewedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getReviewedDate() {
        return reviewedDate;
    }

    public void setReviewedDate(Date reviewedDate) {
        this.reviewedDate = reviewedDate;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
