package com.concretepage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.concretepage.entity.ProjectGenerator;

public interface ProjectGeneratorRepository extends CrudRepository<ProjectGenerator,Integer> {
	//List<ProjectGenerator> findById(ID id));

}
