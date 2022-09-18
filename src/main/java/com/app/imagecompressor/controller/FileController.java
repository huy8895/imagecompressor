package com.app.imagecompressor.controller;

import com.app.imagecompressor.proxy.UpLoadImageProxy;
import com.app.imagecompressor.service.v1.ImageCompressor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("api/file")
@RequiredArgsConstructor
public class FileController {
    private final UpLoadImageProxy upLoadImageProxy;

    @PostMapping("/v1/upload")
    public Object compressorV1(@RequestParam("file") MultipartFile file) {
        return upLoadImageProxy.upload(file);
    }
}
