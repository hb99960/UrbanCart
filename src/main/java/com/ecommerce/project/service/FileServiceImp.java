package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImp  implements FileService{

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        return "";
    }
}
