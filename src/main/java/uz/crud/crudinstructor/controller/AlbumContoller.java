package uz.crud.crudinstructor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.AlbumDto;
import uz.crud.crudinstructor.entity.Album;
import uz.crud.crudinstructor.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumContoller {

    private AlbumService albumService;

    @Autowired
    public AlbumContoller(AlbumService albumService) {
        this.albumService = albumService;
    }


    @PostMapping("/add")
    public ResponseEntity<Album> createAlbum(@RequestBody AlbumDto albumDto) {
        Album album1 = albumService.addAlbum(albumDto);
        return new ResponseEntity<>(album1, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Album>> getAlbum() {
        List<Album> albums = albumService.getAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }


}
