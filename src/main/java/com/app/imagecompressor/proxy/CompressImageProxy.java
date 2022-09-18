package com.app.imagecompressor.proxy;

import com.app.imagecompressor.dto.compress.CompressStatusResDto;
import com.app.imagecompressor.dto.compress.CompressedImageResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class CompressImageProxy extends BasedProxy {
    private final String COMPRESS_URL = "https://imagecompressor.com/compress/";
    private final String STATUS_URL = "https://imagecompressor.com/status/";


    public CompressImageProxy(RestTemplate restTemplate) {
        super(restTemplate);
    }

    public CompressStatusResDto compress(String sid, String fileId, int quality) {
//		https://imagecompressor.com/compress/l60atqjg51jb3647/file_1hcu10n1b1t2k2hnp9ma15eo3d?quality=10
        String urlCompress = UriComponentsBuilder.fromHttpUrl(COMPRESS_URL)
                                                 .path(sid)
                                                 .path("/")
                                                 .path(fileId)
                                                 .queryParam("quality", quality)
                                                 .toUriString();
        log.info("urlCompress: {}", urlCompress);
        return this.Get(urlCompress, initHeader(), CompressStatusResDto.class);
    }


    public CompressedImageResDto status(String sid, String fileId) {
//		https://imagecompressor.com/status/l60atqjg51jb3647/file_1hcu10n1b1t2k2hnp9ma15eo3d?rnd=0.9457614945405795
        String urlCompressStatus = UriComponentsBuilder.fromHttpUrl(STATUS_URL)
                                                       .path(sid)
                                                       .path("/")
                                                       .path(fileId)
                                                       .toUriString();
        log.info("urlCompressStatus: {}", urlCompressStatus);
        return this.Get(urlCompressStatus, initHeader(), CompressedImageResDto.class);
    }


}
