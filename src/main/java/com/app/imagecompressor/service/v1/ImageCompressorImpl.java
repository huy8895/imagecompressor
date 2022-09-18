package com.app.imagecompressor.service.v1;

import com.app.imagecompressor.proxy.DownLoadImageProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageCompressorImpl implements ImageCompressor {
    private final DownLoadImageProxy downLoadImageProxy;
    @Override
    public Object compress(MultipartFile file, int quality) {

        return null;
    }
}
