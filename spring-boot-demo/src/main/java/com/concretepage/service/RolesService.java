package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.Roles;
import com.concretepage.repository.RolesRepository;

@Component
public class RolesService implements IRolesService{
	@Autowired
	private RolesRepository rolesrepository;
	
	@Override
	public List<Roles> getAllRoles() {
		List<Roles> list = new ArrayList<>();
		rolesrepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Roles getRolesById(int rolesId) {
		Roles obj  = rolesrepository.findById(rolesId).get();
		return obj;
	}

	@Override
	public boolean addRoles(Roles roles) {
		if (rolesrepository.existsById(roles.getRoleId())) {
        	return false;
        }else {
         rolesrepository.save(roles);
         return true;
        }
	}

	@Override
	public void updateRoles(Roles roles) {
		rolesrepository.save(roles);
	}

	@Override
	public void deleteRoles(int rolesId) {
		rolesrepository.delete(getRolesById(rolesId));

	}

}
