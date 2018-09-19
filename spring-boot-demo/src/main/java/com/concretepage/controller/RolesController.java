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

import com.concretepage.entity.Roles;
import com.concretepage.service.IRolesService;

@Controller
@RequestMapping("user")
public class RolesController {
	@Autowired
	private IRolesService rolesService;
	
	@GetMapping("role/{id}")
	public ResponseEntity<Roles> getRolesById(@PathVariable("id") int id) {
		Roles roles = rolesService.getRolesById(id);
		return new ResponseEntity<Roles>(roles, HttpStatus.OK);
	}
	@GetMapping("roles")
	public ResponseEntity<List<Roles>> getAllRoless() {
		List<Roles> list = rolesService.getAllRoles();
		return new ResponseEntity<List<Roles>>(list, HttpStatus.OK);
	}
	@PostMapping("role")
	public ResponseEntity<Void> addRoles(@RequestBody Roles roles, UriComponentsBuilder builder) {		
		if(!rolesService.addRoles(roles)) 
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/roles/{id}").buildAndExpand(roles.getRoleId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("role")
	public ResponseEntity<Roles> updateRoles(@RequestBody Roles roles) {
		rolesService.updateRoles(roles);
		return new ResponseEntity<Roles>(roles, HttpStatus.OK);
	}
	@DeleteMapping("role/{id}")
	public ResponseEntity<Void> deleteRoles(@PathVariable("id") int id) {
		rolesService.deleteRoles(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
