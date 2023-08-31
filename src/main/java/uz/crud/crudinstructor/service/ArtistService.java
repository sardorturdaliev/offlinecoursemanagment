package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.ArtistDto;
import uz.crud.crudinstructor.entity.Artist;
import uz.crud.crudinstructor.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(ArtistDto artistDto) {
        Artist artist = new Artist();
        artist.setName(artistDto.getName());
        return artistRepository.save(artist);
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }


    public Artist getArtists(Long id) {
        Optional<Artist> optionalArtist = artistRepository.findById(id);
        return optionalArtist.get();
    }


}
