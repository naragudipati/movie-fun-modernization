package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.superbiz.moviefun.moviesapi.albums.AlbumFixtures;
import org.superbiz.moviefun.moviesapi.albums.AlbumInfo;
import org.superbiz.moviefun.moviesapi.albums.AlbumsClient;
import org.superbiz.moviefun.moviesapi.movies.MovieFixtures;
import org.superbiz.moviefun.moviesapi.movies.MovieInfo;
import org.superbiz.moviefun.moviesapi.movies.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private AlbumsClient albumsClient;
    private MoviesClient moviesClient;
    private MovieFixtures movieFixtures;
    private AlbumFixtures albumFixtures;


   public HomeController(AlbumsClient albumClient, MoviesClient moviesClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures){
       this.albumsClient = albumClient;
       this.moviesClient = moviesClient;
       this.movieFixtures = movieFixtures;
       this.albumFixtures = albumFixtures;
   }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
