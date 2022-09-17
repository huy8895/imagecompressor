package com.app.imagecompressor.service.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
public class ImageCompressorImpl implements ImageCompressor {
    @Override
    public Object compress(MultipartFile file, int quality) {
        return null;
    }
}
