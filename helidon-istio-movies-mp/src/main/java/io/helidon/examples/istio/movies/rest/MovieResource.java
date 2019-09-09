package io.helidon.examples.istio.movies.rest;

import io.helidon.examples.istio.movies.model.Movie;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
@RequestScoped
public class MovieResource {
    private MovieProvider movieProvider;

    @Inject
    public MovieResource(MovieProvider movieProvider) {
        this.movieProvider = movieProvider;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAllMovies(){
        return movieProvider.getMovies();
    }
}
