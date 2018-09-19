package com.concretepage.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.concretepage.entity.RequestAccess;

@Component
public interface IRequestAccessService {
	List<RequestAccess> getAllRequestAccess();
	RequestAccess getRequestAccessById(int requestaccessId);
	boolean addRequestAccess(RequestAccess requestaccess);
    void updateRequestAccess(RequestAccess requestaccess);
    void deleteRequestAccess(int requestaccess);
}
