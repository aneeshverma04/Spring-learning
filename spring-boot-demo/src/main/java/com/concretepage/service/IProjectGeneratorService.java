package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.concretepage.entity.ProjectGenerator;

@Component
public interface IProjectGeneratorService {
    List<ProjectGenerator> getAllProjects();
	ProjectGenerator getProjectById(int projectId);
	boolean addProject(ProjectGenerator project);
    void updateProject(ProjectGenerator project);
    void deleteProject(int projectId);
}
