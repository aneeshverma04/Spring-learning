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

import com.concretepage.entity.RequestAccess;
import com.concretepage.service.IRequestAccessService;

@Controller
@RequestMapping("user")
public class RequestAccessController {
	@Autowired
	private IRequestAccessService requestaccessService;
	
	@GetMapping("access/{id}")
	public ResponseEntity<RequestAccess> getRequestAccessById(@PathVariable("id") int id) {
		RequestAccess requestaccess = requestaccessService.getRequestAccessById(id);
		return new ResponseEntity<RequestAccess>(requestaccess, HttpStatus.OK);
	}
	@GetMapping("requestaccess")
	public ResponseEntity<List<RequestAccess>> getAllRequestAccesss() {
		List<RequestAccess> list = requestaccessService.getAllRequestAccess();
		return new ResponseEntity<List<RequestAccess>>(list, HttpStatus.OK);
	}
	@PostMapping("access")
	public ResponseEntity<Void> addRequestAccess(@RequestBody RequestAccess requestaccess, UriComponentsBuilder builder) {		
		if(!requestaccessService.addRequestAccess(requestaccess)) 
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/requestaccess/{id}").buildAndExpand(requestaccess.getRoleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("access")
	public ResponseEntity<RequestAccess> updateRequestAccess(@RequestBody RequestAccess requestaccess) {
		requestaccessService.updateRequestAccess(requestaccess);
		return new ResponseEntity<RequestAccess>(requestaccess, HttpStatus.OK);
	}
	@DeleteMapping("access/{id}")
	public ResponseEntity<Void> deleteRequestAccess(@PathVariable("id") int id) {
		requestaccessService.deleteRequestAccess(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
