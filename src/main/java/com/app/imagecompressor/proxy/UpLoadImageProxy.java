package com.app.imagecompressor.proxy;

import com.app.imagecompressor.dto.upload.UploadResDto;
import com.app.imagecompressor.ultil.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UpLoadImageProxy extends BasedProxy{
	private final String UPLOAD_URL = "https://imagecompressor.com/upload/";
	private final String RND = "0.8415633303065515";


	public UpLoadImageProxy(RestTemplate restTemplate) {
		super(restTemplate);
	}

	public UploadResDto upload(Resource resource, String originalFilename){
		log.info("start upload : {}", originalFilename);
		String url = UPLOAD_URL.concat(StringUtils.randomSid());

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body
				= new LinkedMultiValueMap<>();

		body.add("file", resource);
		body.add("id", StringUtils.randomFileId());
		body.add("name", originalFilename);
		body.add("rnd", RND);

		HttpEntity<MultiValueMap<String, Object>> requestEntity
				= new HttpEntity<>(body, headers);
		return this.Post(url, requestEntity, UploadResDto.class	);
	}
}
