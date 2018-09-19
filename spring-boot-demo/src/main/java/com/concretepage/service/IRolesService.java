package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.concretepage.entity.Roles;

@Component
public interface IRolesService {
	List<Roles> getAllRoles();
	Roles getRolesById(int roleId);
	boolean addRoles(Roles role);
    void updateRoles(Roles role);
    void deleteRoles(int role);
}
