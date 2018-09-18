package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.ProjectGenerator;
import com.concretepage.repository.ProjectGeneratorRepository;

@Component
public class ProjectGeneratorService implements IProjectGeneratorService{

	@Autowired
	private ProjectGeneratorRepository projectgeneratorrepository;
	
	@Override
	public ProjectGenerator getProjectById(int projectId) {
		ProjectGenerator obj  = projectgeneratorrepository.findById(projectId).get();
		return obj;
	}

	@Override
	public List<ProjectGenerator> getAllProjects() {
		List<ProjectGenerator> list = new ArrayList<>();
		projectgeneratorrepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public synchronized boolean addProject(ProjectGenerator project) {
		if (projectgeneratorrepository.existsById(project.getProjectId())) {
        	return false;
        }else {
         projectgeneratorrepository.save(project);
         return true;
        }
	}

	@Override
	public void updateProject(ProjectGenerator project) {
		projectgeneratorrepository.save(project);		
	}
	

	@Override
	public void deleteProject(int projectId) {
		projectgeneratorrepository.delete(getProjectById(projectId));
		
	}

}
