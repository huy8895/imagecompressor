package com.app.imagecompressor.service.v1;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCompressor {
    Object compress(MultipartFile file, int quality);
}
