package com.app.imagecompressor.service.v1;

import com.app.imagecompressor.dto.upload.UploadResDto;
import com.app.imagecompressor.proxy.CompressImageProxy;
import com.app.imagecompressor.proxy.DownLoadImageProxy;
import com.app.imagecompressor.proxy.UpLoadImageProxy;
import com.app.imagecompressor.ultil.StringUtils;
import com.app.imagecompressor.ultil.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageCompressorImpl implements ImageCompressor {
    private final DownLoadImageProxy downLoadImageProxy;
    private final UpLoadImageProxy upLoadImageProxy;
    private final CompressImageProxy compressImageProxy;

    @Override
    public byte[] compress(MultipartFile file, int quality) {
        UploadResDto upload = upLoadImageProxy.upload(file.getResource(), file.getOriginalFilename());
        return compress(quality, upload);
    }

    @Override
    public byte[] compress(String url, int quality) {
        var response = downLoadImageProxy.downLoadV2(url);
        String filename = StringUtils.randomFileId()
                                     .concat(".jpg");
        ByteArrayResource contentsAsResource = new ByteArrayResource(response.getBody()) {
            @Override
            public String getFilename() {
                return filename; // Filename has to be returned in order to be able to post.
            }
        };


        UploadResDto upload = upLoadImageProxy.upload(contentsAsResource, filename);
        return this.compress(quality, upload);
    }

    private byte[] compress(int quality, UploadResDto upload) {
        String sid = upload.getImage()
                           .getSid();
        String fileId = upload.getId();

        final var compress = compressImageProxy.compress(sid, fileId, quality);
        if (!"success".equals(compress.getStatus())){
            throw new RuntimeException("compress error!!!");
        }

        var status = compressImageProxy.status(sid, fileId);

        log.info("status: {}", Utils.toJson(status));

//        https://imagecompressor.com//files/b5q17fkdfdq4r1bo/file_aur1tf51pom1bmh155t177k17k/optimized-negs.jpg?y7n0
        String compressed_url = "https://imagecompressor.com".concat(status.getCompressed_url());
        return downLoadImageProxy.downLoad(compressed_url);
    }
}
