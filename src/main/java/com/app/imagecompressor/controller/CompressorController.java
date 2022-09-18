package com.app.imagecompressor.controller;

import com.app.imagecompressor.service.v1.ImageCompressor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("api/compressor")
@RequiredArgsConstructor
public class CompressorController {
    private final ImageCompressor imageCompressor;

    @PostMapping("/v1")
    public Object compressorV1(@RequestParam("file") MultipartFile file,
                               @RequestParam("quality") int quality) {
        byte[] compressData = imageCompressor.compress(file, quality);
        return ResponseEntity.ok()
                             .contentType(MediaType.valueOf(file.getContentType()))
                             .body(compressData);
    }

    @PostMapping("/v2")
    public Object compressorV2(@RequestParam("url") String url,
                               @RequestParam("quality") int quality) {
        byte[] compressData = imageCompressor.compress(url, quality);
        return ResponseEntity.ok()
//                             .contentType(MediaType.valueOf(file.getContentType()))
                             .body(compressData);
    }
}
