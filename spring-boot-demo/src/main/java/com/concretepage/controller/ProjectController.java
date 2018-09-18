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

import com.concretepage.entity.ProjectGenerator;
import com.concretepage.service.IProjectGeneratorService;

@Controller
@RequestMapping("user")
public class ProjectController {
	@Autowired
	private IProjectGeneratorService projectService;
	
	@GetMapping("project/{id}")
	public ResponseEntity<ProjectGenerator> getProjectById(@PathVariable("id") int id) {
		ProjectGenerator project = projectService.getProjectById(id);
		return new ResponseEntity<ProjectGenerator>(project, HttpStatus.OK);
	}
	@GetMapping("projects")
	public ResponseEntity<List<ProjectGenerator>> getAllProjects() {
		List<ProjectGenerator> list = projectService.getAllProjects();
		return new ResponseEntity<List<ProjectGenerator>>(list, HttpStatus.OK);
	}
	@PostMapping("project")
	public ResponseEntity<Void> addProject(@RequestBody ProjectGenerator project, UriComponentsBuilder builder) {		
		if(!projectService.addProject(project)) 
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/project/{id}").buildAndExpand(project.getProjectId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("project")
	public ResponseEntity<ProjectGenerator> updateProject(@RequestBody ProjectGenerator project) {
		projectService.updateProject(project);
		return new ResponseEntity<ProjectGenerator>(project, HttpStatus.OK);
	}
	@DeleteMapping("project/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") int id) {
		projectService.deleteProject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
