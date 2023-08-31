package uz.crud.crudinstructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crud.crudinstructor.dto.requestDto.ArtistDto;
import uz.crud.crudinstructor.entity.Artist;
import uz.crud.crudinstructor.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistContoller {

    private ArtistService artistService;

    @Autowired
    public ArtistContoller(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/add")
    public ResponseEntity<Artist> addArtist(@RequestBody ArtistDto artist) {
        Artist artist1 = artistService.addArtist(artist);
        return new ResponseEntity<>(artist1, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Artist>> getArtists() {
        List<Artist> list = artistService.getArtists();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
