package com.app.imagecompressor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("api/compressor")
@RequiredArgsConstructor
public class CompressorController {
    @PostMapping("/v1")
    public Object compressorV1(MultipartFile file, int quality){
        return null;
    }
}
