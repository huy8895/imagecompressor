package com.app.imagecompressor.proxy;

import com.app.imagecompressor.dto.upload.UploadResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class BasedProxy {

	private final RestTemplate restTemplate;

	protected HttpHeaders initHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		return headers;
	}

	protected HttpHeaders initHeader(String username, String password, MediaType mediaType) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setBasicAuth(username, password);
		return headers;
	}

	protected HttpHeaders initHeaderAppFormUrl() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}

	protected <T> T PostAppFormUrl(String username, String password,String api, HttpHeaders headers, Class<T> clazz) {
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("client_secret", password);
		map.add("client_id", username);
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, httpEntity, clazz);
		return response.getBody();
	}

	protected <T> T PostAppFormUrl(Map<String, String> maps, String api, HttpHeaders headers, Class<T> clazz) {
		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		for (Map.Entry<String, String> entry : maps.entrySet()) {
			map.add(entry.getKey(), entry.getValue());
		}

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, httpEntity, clazz);
		return response.getBody();
	}

	protected HttpHeaders initHeader(String beareToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(beareToken);
		return headers;
	}

	protected HttpHeaders initHeaderApplicationPDF(String beareToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
		headers.setBearerAuth(beareToken);
		return headers;
	}

	protected <T> T Get(String api, HttpHeaders headers, Class<T> clazz) {
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.GET, entity, clazz);
		if (response.getStatusCode().equals(HttpStatus.MOVED_PERMANENTLY)){
			return this.Get(response.getHeaders().getLocation().toString(), headers,clazz);
		}
		return response.getBody();
	}

	protected <T> T Post(String api, HttpHeaders headers, String payload, Class<T> clazz) {
		HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, entity, clazz);
		return response.getBody();
	}

	protected <T> T Post(String api,  HttpEntity entity, Class<T> clazz) {
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, entity, clazz);
		return response.getBody();
	}

	protected <T> T Post(String api, HttpHeaders headers, Object payload, Class<T> clazz) {
		HttpEntity<Object> entity = new HttpEntity<>(payload, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, entity, clazz);
		return response.getBody();
	}

	protected <T> T Put(String api, HttpHeaders headers, Object payload, Class<T> clazz) {
		HttpEntity<Object> entity = new HttpEntity<>(payload, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.PUT, entity, clazz);
		return response.getBody();
	}
	
	protected <T> T Put(String api, HttpHeaders headers, String payload, Class<T> clazz) {
		HttpEntity<String> entity = new HttpEntity<String>(payload, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.PUT, entity, clazz);
		return response.getBody();
	}
	
	protected HttpHeaders initEContractHeaderFormData(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.setBearerAuth(accessToken);
		return headers;
	}


	protected <T> T Post(String api, HttpHeaders headers, Map<Object, Object> maps, Class<T> clazz) {
		MultiValueMap<Object, Object> multiValueMap = new LinkedMultiValueMap<>();
		Set<Map.Entry<Object, Object>> setHashMap = maps.entrySet();
		for (Map.Entry<Object, Object> item : setHashMap) {
			multiValueMap.add(item.getKey(), item.getValue());
		}
		HttpEntity<?> entity = new HttpEntity<>(multiValueMap, headers);
		ResponseEntity<T> response = restTemplate.exchange(api, HttpMethod.POST, entity, clazz);
		return response.getBody();
	}
}
