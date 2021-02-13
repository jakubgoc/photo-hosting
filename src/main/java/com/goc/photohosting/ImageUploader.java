package com.goc.photohosting;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.goc.photohosting.model.Image;
import com.goc.photohosting.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private ImageRepo imageRepo;
    private Cloudinary cloudinary;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo=imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dypgpooos",
                "api_key", "256529416828268",
                "api_secret", "JwCCP9mmAyFAob6iD7Xf0jxryf0"));
    }

    public String UploadFileAndSaveToDb(String path){
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();
    }
}
