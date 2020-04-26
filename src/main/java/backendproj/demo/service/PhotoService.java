package backendproj.demo.service;

import backendproj.demo.dao.PhotoRepository;
import backendproj.demo.model.Photo;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepo;

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        System.out.println("create");
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        System.out.println("sett");
        photo.toString();
        photo = photoRepo.insert(photo);

        return photo.getId();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
