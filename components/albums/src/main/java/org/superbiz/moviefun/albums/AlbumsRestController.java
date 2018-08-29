package org.superbiz.moviefun.albums;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsRestController {

    private AlbumsBean albumsBean;

    public AlbumsRestController(AlbumsBean albumsBean) {
        this.albumsBean = albumsBean;
    }

    @PostMapping
    public void addMovie(@RequestBody Album album) {
        albumsBean.addAlbum(album);
    }

    @DeleteMapping
    public void deleteMovieId(@RequestBody Album album) {
        albumsBean.deleteAlbum(album);
    }

    @GetMapping("/{albumId}")
    public Album find(@PathVariable long albumId  ) {
        return albumsBean.find(albumId);
    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumsBean.getAlbums();
    }

    @PutMapping
    public void updateAlbum(@RequestBody Album album) {
        albumsBean.updateAlbum(album);
    }
}
