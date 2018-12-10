package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

	@GetMapping("/auth")
	public void auth(@RequestParam("code") String code) {
		log.info("access to auth method");
		log.info(("code={}"), code);

		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa57d0d99cdcd77c5&secret=74edac6d4f9a1f0a03246c17a85ec6ae&code=" + code + "&grant_type=authorization_code";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		log.info("response={}", response);

	}
}
