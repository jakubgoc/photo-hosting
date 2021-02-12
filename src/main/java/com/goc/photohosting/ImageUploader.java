package com.goc.photohosting;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    public ImageUploader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dypgpooos",
                "api_key", "256529416828268",
                "api_secret", "JwCCP9mmAyFAob6iD7Xf0jxryf0"));
    }

    public String UploadFile(String path){
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();
    }

    public static void main(String[] args) throws IOException {
    }
}
