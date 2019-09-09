package io.helidon.examples.istio.movies.rest;

import io.helidon.examples.istio.movies.model.Movie;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MovieProvider {
    private String[] movieNames = {"Prisoners", "The Grand Budapest Hotel", "Interstellar", "The Wolf of Wall Street", "Mad Max: Fury Road","Manchester by the Sea"};
    private List<Movie> movies = new ArrayList();

    public MovieProvider() {
        initMoviesWithRandomData();
    }

    private void initMoviesWithRandomData() {
         for (int i = 0; i < movieNames.length; i++) {
             Movie movie = new Movie(1000+i,movieNames[i], null );
             movies.add(movie);
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
