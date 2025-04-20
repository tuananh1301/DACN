package com.example.WebsiteBanHang2.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadService {
    public static void uploadFile(String uploadDir, String fileName, MultipartFile file) throws IOException {
        Path uploadFath = Paths.get(uploadDir);
        if(!Files.exists(uploadFath)) {
            Files.createDirectories(uploadFath);
        }

        try{
            InputStream inputStream = file.getInputStream();
            Path filePath = uploadFath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }
}
