package com.app.imagecompressor.controller;

import com.app.imagecompressor.proxy.DownLoadImageProxy;
import com.app.imagecompressor.proxy.UpLoadImageProxy;
import com.app.imagecompressor.service.v1.ImageCompressor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("api/file")
@RequiredArgsConstructor
public class FileController {
    private final UpLoadImageProxy upLoadImageProxy;
    private final DownLoadImageProxy downLoadImageProxy;

    @PostMapping("/v1/upload")
    public Object upload(@RequestParam("file") MultipartFile file) {
        // TODO: 9/18/2022 file.getContentType() == image/jpeg
        return upLoadImageProxy.upload(file);
    }

    @GetMapping("/v1/download")
    public Object download(@RequestParam("url") String url) {
        byte[] imageData = downLoadImageProxy.downLoad(url);
        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.IMAGE_JPEG)
                             .body(imageData);
    }
}
