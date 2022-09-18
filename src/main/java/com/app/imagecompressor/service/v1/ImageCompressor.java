package com.app.imagecompressor.service.v1;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCompressor {
    byte[] compress(MultipartFile file, int quality);

    byte[] compress(String url, int quality);
}
