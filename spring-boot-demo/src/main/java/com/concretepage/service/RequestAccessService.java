package com.concretepage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.RequestAccess;
import com.concretepage.repository.RequestAccessRepository;

@Component
public class RequestAccessService implements IRequestAccessService{
	@Autowired
	private RequestAccessRepository requestaccessrepository;
	
	@Override
	public List<RequestAccess> getAllRequestAccess() {
		List<RequestAccess> list = new ArrayList<>();
		requestaccessrepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public RequestAccess getRequestAccessById(int requestaccessId) {
		RequestAccess obj  = requestaccessrepository.findById(requestaccessId).get();
		return obj;
	}

	@Override
	public boolean addRequestAccess(RequestAccess requestaccess) {
		if (requestaccessrepository.existsById(requestaccess.getRequestId())) {
        	return false;
        }else {
         requestaccessrepository.save(requestaccess);
         return true;
        }
	}

	@Override
	public void updateRequestAccess(RequestAccess requestaccess) {
		requestaccessrepository.save(requestaccess);
	}

	@Override
	public void deleteRequestAccess(int requestaccessId) {
		requestaccessrepository.delete(getRequestAccessById(requestaccessId));

	}

}
