package com.app.imagecompressor.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class DownLoadImageProxy extends BasedProxy{


	public DownLoadImageProxy(RestTemplate restTemplate) {
		super(restTemplate);
	}

	public byte[] downLoad(String url){
		log.info("start download: {}", url);
		return this.Get(url, initHeader(), byte[].class);
	}

	public ResponseEntity<byte[]> downLoadV2(String url){
		log.info("start download: {}", url);
		return this.Get(url, byte[].class);
	}
}
