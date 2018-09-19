package com.concretepage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Platform;
import com.concretepage.service.IPlatformService;

@Controller
@RequestMapping("user")
public class PlatformController {
	@Autowired
	private IPlatformService platformService;
	
	@GetMapping("platform/{id}")
	public ResponseEntity<Platform> getPlatformById(@PathVariable("id") int id) {
		Platform platform = platformService.getPlatformById(id);
		return new ResponseEntity<Platform>(platform, HttpStatus.OK);
	}
	@GetMapping("platforms")
	public ResponseEntity<List<Platform>> getAllPlatforms() {
		List<Platform> list = platformService.getAllPlatforms();
		return new ResponseEntity<List<Platform>>(list, HttpStatus.OK);
	}
	@PostMapping("platform")
	public ResponseEntity<Void> addPlatform(@RequestBody Platform platform, UriComponentsBuilder builder) {		
		if(!platformService.addPlatform(platform)) 
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/platform/{id}").buildAndExpand(platform.getPlatformId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("platform")
	public ResponseEntity<Platform> updatePlatform(@RequestBody Platform platform) {
		platformService.updatePlatform(platform);
		return new ResponseEntity<Platform>(platform, HttpStatus.OK);
	}
	@DeleteMapping("platform/{id}")
	public ResponseEntity<Void> deletePlatform(@PathVariable("id") int id) {
		platformService.deletePlatform(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
