package br.com.treinaweb.ediaristas.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HiRestController {

	@GetMapping
	public Map<String, String> hello(){
		var json =  new HashMap<String, String>();
		json.put("message", "Hello");

		return json;
	}
}
