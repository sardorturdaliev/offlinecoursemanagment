package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.crud.crudinstructor.dto.requestDto.AlbumDto;
import uz.crud.crudinstructor.entity.Album;
import uz.crud.crudinstructor.entity.Artist;
import uz.crud.crudinstructor.repository.AlbumRepository;

import java.util.List;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;
    private ArtistService artistService;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }


    public Album addAlbum(AlbumDto albumDto) {// title,artistId
        Album album = new Album();
        album.setTitle(albumDto.getTitle());
        if (albumDto.getArtistId() == null) {
            return albumRepository.save(album);
        }
        Artist artist = artistService.getArtists(albumDto.getArtistId());
        album.setArtist(artist);
        return albumRepository.save(album);
    }

    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }


}
