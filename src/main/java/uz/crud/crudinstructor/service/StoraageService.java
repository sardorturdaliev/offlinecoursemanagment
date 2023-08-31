package uz.crud.crudinstructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.crud.crudinstructor.entity.ImageData;
import uz.crud.crudinstructor.repository.FileDataRepository;
import uz.crud.crudinstructor.repository.StorageRepository;
import uz.crud.crudinstructor.utils.Utils;

import java.io.IOException;
import java.util.Optional;

@Service

public class StoraageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private FileDataRepository fileDataRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imagesourse(Utils.compressImage(file.getBytes())).build());

        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    public byte[] downloadImage(String filename){
        Optional<ImageData> dbImagedata = storageRepository.findByName(filename);
        byte[] images = Utils.decompressImage(dbImagedata.get().getImagesourse());
        return images;
    }




}
