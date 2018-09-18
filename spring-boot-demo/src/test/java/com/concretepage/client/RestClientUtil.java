package com.concretepage.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.concretepage.entity.ProjectGenerator;

public class RestClientUtil {
    public void getProjectByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9000/user/project/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<ProjectGenerator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ProjectGenerator.class, 1);
        ProjectGenerator project = responseEntity.getBody();
        System.out.println("Id:"+project.getProjectId()+", Name:"+project.getProjectName()
                 +", PackageName:"+project.getPackageName());      
    }
	public void getAllProjectsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9000/user/projects";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<ProjectGenerator[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ProjectGenerator[].class);
        ProjectGenerator[] projects = responseEntity.getBody();
        for(ProjectGenerator project : projects) {
              System.out.println("Id:"+project.getProjectId()+", Name:"+project.getProjectName()
              + ", PackageName:"+project.getPackageName());
        }
    }
    public void addProjectDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9000/user/project";
	    ProjectGenerator objProject = new ProjectGenerator();
	    objProject.setProjectName("Spring REST Security using Hibernate");
	    objProject.setPackageName("Spring");
        HttpEntity<ProjectGenerator> requestEntity = new HttpEntity<ProjectGenerator>(objProject, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateProjectDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9000/user/project";
	    ProjectGenerator objProject = new ProjectGenerator();
	    objProject.setProjectId(1);
	    objProject.setProjectName("Update:Java Concurrency");
	    objProject.setPackageName("Java");
        HttpEntity<ProjectGenerator> requestEntity = new HttpEntity<ProjectGenerator>(objProject, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteProjectDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:9000/user/project/{id}";
        HttpEntity<ProjectGenerator> requestEntity = new HttpEntity<ProjectGenerator>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getProjectByIdDemo();
    	//util.addProjectDemo();
    	//util.updateProjectDemo();
    	//util.deleteProjectDemo();
    	util.getAllProjectsDemo();    	
    }    
}
