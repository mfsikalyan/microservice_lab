package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SentenceRibbonController {

	@Autowired
	@LoadBalanced
	RestTemplate template;

	@GetMapping("/sentence-ribbon")
	public @ResponseBody String getSentence() {
		return getWord("lab-4-subject") + " " + getWord("lab-4-verb") + " " + getWord("LAB-4-ARTICLE") + " "
				+ getWord("LAB-4-ADJECTIVE") + " " + getWord("LAB-4-NOUN") + ".";
	}

	public String getWord(String service) {
		return template.getForObject("http://" + service, String.class);
	}

}
